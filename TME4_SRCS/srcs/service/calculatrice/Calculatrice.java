package srcs.service.calculatrice;

import java.io.Serializable;

public interface Calculatrice {

	public Integer add(Integer x, Integer y);

	public Integer sous(Integer x, Integer y);

	public Integer mult(Integer x, Integer y);

	public ResDiv div(Integer x, Integer y);

	public static class ResDiv implements Serializable {

		private static final long serialVersionUID = 1L;

		Integer x, y;

		public ResDiv(Integer x, Integer y) {
			this.x = x;
			this.y = y;
		}

		public int getQuotient() {
			return x / y;
		}

		public int getReste() {
			return x % y;
		}
	}

}
