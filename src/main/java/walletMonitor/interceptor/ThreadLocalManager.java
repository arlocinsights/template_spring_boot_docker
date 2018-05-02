package walletMonitor.interceptor;

import java.util.Date;
import java.util.UUID;

public class ThreadLocalManager {

	private static final ThreadLocal<String> TRANSACTION_ID_TL = new ThreadLocal<String>();
	private static final ThreadLocal<String> HEADER_INFO_TL = new ThreadLocal<String>();
	private static final ThreadLocal<Date> START_TIME = new ThreadLocal<Date>();

	public static void setStartTime() {
		START_TIME.set(new Date());
	}

	public static Date getStartTime() {
		return START_TIME.get();
	}

	public static void setTransactionId() {
		UUID randomUUID = UUID.randomUUID();
		TRANSACTION_ID_TL.set(randomUUID.toString());
	}

	public static String getTransactionId() {
		return TRANSACTION_ID_TL.get();
	}

	public static void clearTransactionId() {

		TRANSACTION_ID_TL.set(null);
	}

	public static void setHeaderInfo(String headerInfo) {
		HEADER_INFO_TL.set(headerInfo);
	}

	public static String getHeaderInfo() {
		return HEADER_INFO_TL.get();
	}

	public static void clearHeaderInfo() {
		HEADER_INFO_TL.set(null);
	}
}