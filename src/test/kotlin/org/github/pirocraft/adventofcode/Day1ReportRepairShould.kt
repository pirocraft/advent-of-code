package org.github.pirocraft.adventofcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day1ReportRepairShould {
    private val reportRepair = ReportRepair()

    @Test
    internal fun `multiply the two entries whose sum is 2020`() {
        assertEquals(514579, reportRepair.multiply2EntriesWhoseSumIs2020(expenseReportExample.split("\n")))
        assertEquals(1016964, reportRepair.multiply2EntriesWhoseSumIs2020(expenseReport.split("\n")))
    }

    @Test
    internal fun `multiply the three entries whose sum is 2020`() {
        assertEquals(241861950, reportRepair.multiply3EntriesWhoseSumIs2020(expenseReportExample.split("\n")))
        assertEquals(182588480, reportRepair.multiply3EntriesWhoseSumIs2020(expenseReport.split("\n")))
    }

    class ReportRepair {
        fun multiply2EntriesWhoseSumIs2020(expenseReport: List<String>): Int = expenseReport
            .map(String::toInt)
            .let { expenses ->
                expenses.map { currentExpense ->
                    currentExpense to expenses.firstOrNull { currentExpense + it == 2020 }
                }.first { (a, b) -> b != null }.let { (a, b) -> a * b!! }

            }

        fun multiply3EntriesWhoseSumIs2020(expenseReport: List<String>): Int = expenseReport
            .map(String::toInt)
            .let { expenses ->
                expenses.flatMap { currentExpense ->
                    expenses.flatMap { intermediateExpense ->
                        expenses.mapNotNull {
                            if (currentExpense + intermediateExpense + it == 2020)
                                currentExpense * intermediateExpense * it
                            else null
                        }
                    }
                }.first()
            }
    }

    val expenseReportExample = "1721\n" +
            "979\n" +
            "366\n" +
            "299\n" +
            "675\n" +
            "1456"

    val expenseReport = "1782\n" +
            "1344\n" +
            "1974\n" +
            "1874\n" +
            "1800\n" +
            "1973\n" +
            "1416\n" +
            "1952\n" +
            "1982\n" +
            "1506\n" +
            "1642\n" +
            "1514\n" +
            "1978\n" +
            "1895\n" +
            "1747\n" +
            "1564\n" +
            "1398\n" +
            "1683\n" +
            "1886\n" +
            "1492\n" +
            "1629\n" +
            "1433\n" +
            "295\n" +
            "1793\n" +
            "1740\n" +
            "1852\n" +
            "1697\n" +
            "1471\n" +
            "1361\n" +
            "1751\n" +
            "1426\n" +
            "2004\n" +
            "1763\n" +
            "1663\n" +
            "1742\n" +
            "1666\n" +
            "1733\n" +
            "1880\n" +
            "1600\n" +
            "1723\n" +
            "1478\n" +
            "1912\n" +
            "1820\n" +
            "1615\n" +
            "1875\n" +
            "1547\n" +
            "1554\n" +
            "752\n" +
            "1905\n" +
            "1368\n" +
            "954\n" +
            "1425\n" +
            "1391\n" +
            "691\n" +
            "1835\n" +
            "744\n" +
            "1850\n" +
            "1713\n" +
            "1995\n" +
            "1926\n" +
            "1817\n" +
            "1774\n" +
            "1986\n" +
            "2010\n" +
            "1427\n" +
            "1609\n" +
            "1927\n" +
            "1362\n" +
            "1420\n" +
            "1722\n" +
            "1590\n" +
            "1925\n" +
            "1617\n" +
            "1434\n" +
            "1826\n" +
            "1636\n" +
            "1687\n" +
            "1946\n" +
            "704\n" +
            "1797\n" +
            "1517\n" +
            "1801\n" +
            "1865\n" +
            "1963\n" +
            "1828\n" +
            "1829\n" +
            "1955\n" +
            "1832\n" +
            "1987\n" +
            "1585\n" +
            "1646\n" +
            "1575\n" +
            "1351\n" +
            "1345\n" +
            "1729\n" +
            "1933\n" +
            "1918\n" +
            "1902\n" +
            "1490\n" +
            "1627\n" +
            "1370\n" +
            "1650\n" +
            "1340\n" +
            "1539\n" +
            "1588\n" +
            "1715\n" +
            "1573\n" +
            "1384\n" +
            "1403\n" +
            "1673\n" +
            "1750\n" +
            "1578\n" +
            "1831\n" +
            "1849\n" +
            "1719\n" +
            "1359\n" +
            "2008\n" +
            "1837\n" +
            "1958\n" +
            "480\n" +
            "1388\n" +
            "1770\n" +
            "1999\n" +
            "1066\n" +
            "1730\n" +
            "1541\n" +
            "1802\n" +
            "1962\n" +
            "1891\n" +
            "1816\n" +
            "1505\n" +
            "1665\n" +
            "1551\n" +
            "1954\n" +
            "1378\n" +
            "1998\n" +
            "1612\n" +
            "1544\n" +
            "1953\n" +
            "1502\n" +
            "1888\n" +
            "1655\n" +
            "1614\n" +
            "1903\n" +
            "1675\n" +
            "1498\n" +
            "1653\n" +
            "1769\n" +
            "1863\n" +
            "1607\n" +
            "1945\n" +
            "1651\n" +
            "1558\n" +
            "1777\n" +
            "1460\n" +
            "1711\n" +
            "1677\n" +
            "1988\n" +
            "1441\n" +
            "1821\n" +
            "1867\n" +
            "1656\n" +
            "1731\n" +
            "1885\n" +
            "1482\n" +
            "1439\n" +
            "1990\n" +
            "1809\n" +
            "1794\n" +
            "1951\n" +
            "1858\n" +
            "1969\n" +
            "509\n" +
            "1486\n" +
            "1971\n" +
            "1557\n" +
            "1896\n" +
            "1884\n" +
            "1834\n" +
            "1814\n" +
            "1216\n" +
            "1997\n" +
            "1966\n" +
            "1808\n" +
            "1754\n" +
            "1804\n" +
            "1684\n" +
            "2001\n" +
            "1699\n" +
            "1781\n" +
            "1429\n" +
            "1322\n" +
            "1603\n" +
            "1596\n" +
            "1823\n" +
            "1700\n" +
            "1552\n" +
            "1352\n" +
            "1621\n" +
            "1669"
}