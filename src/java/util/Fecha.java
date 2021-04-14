package util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import exceptions.ServiceException;

public class Fecha {

	public static java.sql.Date convertirADate(String fecha, String mascara) throws ParseException {
		if (fecha == null || fecha.trim().length() == 0)
			return null;
		else {
			SimpleDateFormat formato = new SimpleDateFormat(mascara);
			formato.setLenient(false);
			long milis;

			milis = formato.parse(fecha).getTime();

			return new java.sql.Date(milis);
		}
	}

	public static Timestamp convertirATimestamp(String fecha, String mascara) throws ParseException {

		if (fecha == null || fecha.trim().length() == 0)
			return null;
		else {
			SimpleDateFormat formato = new SimpleDateFormat(mascara);
			formato.setLenient(false);
			long milis;
			milis = formato.parse(fecha).getTime();

			return new Timestamp(milis);
		}
	}

	public static String convertirAString(java.sql.Date fecha, String mascara) {
		if (fecha == null)
			return null;
		else {
			SimpleDateFormat formato = new SimpleDateFormat(mascara);
			formato.setLenient(false);
			return formato.format(fecha);
		}
	}

	public static String convertirAString(java.sql.Timestamp fecha, String mascara) {
		if (fecha == null)
			return null;
		else {
			SimpleDateFormat formato = new SimpleDateFormat(mascara);
			formato.setLenient(false);
			return formato.format(fecha);
		}

	}

	public static java.sql.Date fechaActualDate() {
		java.sql.Date CurrentDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		return CurrentDate;

	}

// fecha +tiempo  +  milisegundos.
	public static java.sql.Timestamp fechaActual() {
		Timestamp CurrentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
		return CurrentTimestamp;

	}

	public static int compararFechas(java.sql.Date fecha1, java.sql.Date fecha2) throws ServiceException {
		if (fecha1 != null && fecha2 != null) {
			long msinicial = fecha1.getTime();
			long msfin = fecha2.getTime();

			if (msinicial > msfin)
				return 1; // Fecha1 mayor que fecha2
			else if (msinicial < msfin)
				return -1; // Fecha1 menor que fecha2
			else
				return 0; // Fecha1 igual que fecha2
		} else
			throw new ServiceException("se estan comparando fechas nulas");
	}

	public static int compararFechas(java.sql.Timestamp fecha1, java.sql.Timestamp fecha2) throws ServiceException {
		if (fecha1 != null && fecha2 != null) {
			long msinicial = fecha1.getTime();
			long msfin = fecha2.getTime();

			if (msinicial > msfin)
				return 1; // Fecha1 mayor que fecha2
			else if (msinicial < msfin)
				return -1; // Fecha1 menor que fecha2
			else
				return 0; // Fecha1 igual que fecha2
		} else
			throw new ServiceException("se estan comparando fechas nulas");
	}

	public static java.sql.Date sumarDiasFecha(java.sql.Date fechaoriginal, int dias) {
		if (fechaoriginal != null) {
			long msOriginal = fechaoriginal.getTime();
			long msDias = TimeUnit.MILLISECONDS.convert(dias, TimeUnit.DAYS);
			java.sql.Date fechaResultado = new java.sql.Date(msOriginal + msDias);
			return fechaResultado;
		} else
			return null;
	}

	public static java.sql.Timestamp sumarDiasFecha(java.sql.Timestamp fechaoriginal, int dias) {
		if (fechaoriginal != null) {
			long msOriginal = fechaoriginal.getTime();
			long msDias = TimeUnit.MILLISECONDS.convert(dias, TimeUnit.DAYS);
			java.sql.Timestamp fechaResultado = new java.sql.Timestamp(msOriginal + msDias);
			return fechaResultado;
		} else
			return null;
	}

	public static void main(String[] args) {
		System.out.println(fechaActual());
		System.out.println(fechaActualDate());
	}

}
