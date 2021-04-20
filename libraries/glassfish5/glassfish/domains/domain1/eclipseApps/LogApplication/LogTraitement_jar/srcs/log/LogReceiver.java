package srcs.log;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class LogReceiver
 */
@Stateful
@LocalBean
public class LogReceiver implements LogReceiverRemote {

	@PersistenceContext(unitName = "LogJPA")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public LogReceiver() {
	}

	@Override
	public void newLog(Log l) {
		// recupere le nom de la machine sur laquelle le log est associée
		String name_machine = l.getMachine().getNom();
		// verification de l'existance de la machine dans la base
		Query q = em.createQuery("SELECT m FROM Machine m WHERE m.nom = :value_name_machine");
		q.setParameter("value_name_machine", name_machine);
		if (q.getResultList().size() > 0) { // si la liste est > 0 cela signifie que la machine existe dans la base
			// ajout du log donné en parametre dans la base
			em.persist(l);
			em.flush();
		}
		// sinon on ne fait rien

	}

	@Override
	@Asynchronous // ajout d'un log dans la base de maniere asynchrone (cf diapo 49)
	public void newLogAsync(Log l) {
		// recupere le nom de la machine sur laquelle le log est associée
		String name_machine = l.getMachine().getNom();
		// verification de l'existance de la machine dans la base
		Query q = em.createQuery("SELECT m FROM Machine m WHERE m.nom = :value_name_machine");
		q.setParameter("value_name_machine", name_machine);
		if (q.getResultList().size() > 0) { // si la liste est > 0 cela signifie que la machine existe dans la base
			// ajout du log donné en parametre dans la base
			em.persist(l);
			em.flush();
		}
		// sinon on ne fait rien
	}

	@Override
	public Machine[] getMachines() { /* Retourne un tbaleau de toutes les machines enregistrées dans la base */
		// requete permettant d'avoir toutes les machines enregistrées dans la base
		Query q = em.createQuery("SELECT m FROM Machine m ");
		// recupération de la liste contenant le resultat de cette requete, soit les
		// machines
		List<?> l = q.getResultList();
		// converti de la liste en tableau
		Machine[] machines = new Machine[l.size()];
		return l.toArray(machines);
	}

	@Override
	public Log[] getLogs() { /* Retourne la liste de tous les logs de la base */
		// requete permettant d'avoir tous les logs de la base
		Query q = em.createQuery("SELECT l FROM Log l ");
		// recuperation de la liste contenant le resultat de cette requete, soit les
		// logs
		List<?> l = q.getResultList();
		// converti de la liste en tableau
		Log[] log = new Log[l.size()];
		System.out.println("Dans getLogs : " + l.size());
		return l.toArray(log);
	}

	@Override
	public Log[] getLogsWithLevel(String level) {
		// requete permettant de recuperer tous les logs dont le level est celui donné
		// en parametre
		Query q = em.createQuery("SELECT l FROM Log l WHERE l.level = :value_level");
		q.setParameter("value_level", level);
		// recuperation de la liste contenant le resultat de cette requete, soit les
		// logs avec level donné en parametre
		List<?> l = q.getResultList();
		Log[] log = new Log[l.size()];
		return l.toArray(log);
	}

	@Override
	public void mr_proper() { /* Efface le contenu des tables Machines et Log */
		// Recuperation des Logs
		System.out.println("dans mr_proper");
		Log[] logs = getLogs();

		for (int i = 0; i < logs.length; i++) { // pour chaque logs de la base
			Log log = em.find(Log.class, logs[i].getId());
			if (log != null) {
				em.remove(log); // suppression du log de la table Log
				em.flush();
			}
		}

		// Récuperation des Machines
		Machine[] machines = getMachines();

		for (int i = 0; i < machines.length; i++) { // pour chaque machine de la base
			Machine m = em.find(Machine.class, machines[i].getId());
			if (m != null) {
				em.remove(m); // suppression de cette machine de la table Machine
				em.flush();
			}
		}

	}

	@Override
	public Log[] getLogsWithMachine(String name_machine) {
		// requete permettant de recuperer tous les logs associés à la machine dont son
		// nom est donnée en parametre
		Query q = em.createQuery("SELECT m.logs FROM Machine m WHERE m.nom = :value_nom");
		q.setParameter("value_nom", name_machine);
		List<?> l = q.getResultList();

//		List<Log> res = new ArrayList<>();
//		for (int i = 0; i < l.size(); i++) {
//			Log log = (Log) l.get(i);
//			// si c'est un log associé à name_machine
//			if (log.getMachine().getNom().equals(name_machine)) {
//				res.add(log); // ajout de ce log
//			}
//		}

		// converti la liste res en tableau
		Log[] logs = new Log[l.size()];
		return l.toArray(logs);
	}

}
