package com.finrun.trading.common;

public abstract class CONST {
	public enum GLogLevel {
		INFO(0), WARNING(1), ERROR(2), FATAL(3);
		private int key;
		private GLogLevel(int key) {
			this.key = key;
		}
		/**
		 * @return the key
		 */
		public int getKey() {
			return key;
		}
	}
	public static final String RETURN_OK = "0";
	public static final String RETURN_NG = "1";
	/**
	 * 当日有效，指在指定价位全天有效的委托
	 */
	public static final String ORD_INST_TYPE_GFD = "GFD";
	/**
	 * 剩余即撤销，指在指定价位成交，剩余委托自动被撤单
	 */
	public static final String ORD_INST_TYPE_FAK = "FAK";
	/**
	 * 全成或全撤，指在指定价位全部成交，否则系统全部撤单
	 */
	public static final String ORD_INST_TYPE_FOK = "FOK";
}
