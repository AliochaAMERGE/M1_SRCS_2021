# srcs-td2.md


## TD2 Exercice 1 : 

```java
String toString(Object o){
    
    // quand on agrandi une string il faut un StringBuilder ou StringBuffer, car une string est immuable
    StringBuilder sb = new StringBuilder();
    Class<? extends Object> cl = o.getClass();
    sb.append(cl.getSimpleName());
    sb.append("(");

    String s = "";
    // on veut prendre les arguments non statiques
    for(Field f : cl.getDeclaredField()) {
        if(Modifier.isStatic(f.getModifiers())) continue;
        // si les attributs sont privés
        f.setAccessible(true);
        sb.append(f.getType().getSimpleName() + " ");
        sb.append(f.getName() + "=");
        sb.append(f.get(o).toString()+",");        
        f.setAccessible(false);
    }
    sb.append(")");
    return sb.toString();
}

```

## Exercice 2 : 

```java
public static Set<Class<?>> getTypes(Class<?> cl){
        
        Set<Class<?>> resultat = new HashSet<Class<?>>();
        resultat.add(cl);
        if(cl.equals(Object.class))  return resultat;
        
        if(!cl.isInterface())
            resultat.addAll(getTypes(cl.getSuperclass()));
        
        for(Class<?> itf : cl.getInterfaces()) {
            resultat.addAll(getTypes(itf));
        }
        return resultat;        
    }    
    public static Set<Class<?>> getTypes(Object o){
        return getTypes(o.getClass());
    }
```

## Exercice 3 : Annotation

### 1. ExecuteOnBuilding


exo3Q1

```java
@Retention(RUNTIME)
@Target(METHOD)
public @interface ExecuteOnBuilding {
    int value() default 1;
}
```

exo3Q2

```java
public static <T> T deploy(Class<T> cl ) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
    T res = cl.newInstance();
    for(Method m : cl.getMethods()) {
        if(m.isAnnotationPresent(ExecuteOnBuilding.class)) {
            ExecuteOnBuilding e = m.getAnnotation(ExecuteOnBuilding.class);
            for(int i=0;i< e.value();i++) {
                m.invoke(res);
            }
        }
    }
    return res;
}
```