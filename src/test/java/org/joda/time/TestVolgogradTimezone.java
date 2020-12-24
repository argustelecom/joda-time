package org.joda.time;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.joda.time.format.DateTimeFormat;

/**
 * @author m.syrman
 */
public class TestVolgogradTimezone extends TestCase {
	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}

	public static TestSuite suite() {
		return new TestSuite(TestVolgogradTimezone.class);
	}

	public TestVolgogradTimezone(String name) {
		super(name);
	}

	public void testTimezone() {
		DateTimeZone zone = DateTimeZone.forID("Europe/Volgograd");
		DateTime date1 = DateTime.parse("2020-12-27 03:00:00", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")).withZone(zone);
		DateTime date2 = DateTime.parse("2020-12-26 03:00:00", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")).withZone(zone);
		assertEquals(3 * 60 * 60 * 1000, date1.getZone().getOffset(date1.toInstant()));
		assertEquals(4 * 60 * 60 * 1000, date2.getZone().getOffset(date2.toInstant()));
	}
}
