package presentation.view.profiling_details

import domain.model.EnergyConsumption
import javax.swing.event.TableModelListener
import javax.swing.table.TableModel

class EnergyConsumptionTableModel : TableModel {

    enum class ConsumerType {
        TEST, METHOD
    }

    var consumerType = ConsumerType.METHOD
    var items = emptyList<EnergyConsumption>()

    override fun getRowCount() = items.size

    override fun getColumnCount() = 2

    override fun getColumnName(var1: Int): String? {
        return when (var1) {
            0 -> when (consumerType) {
                ConsumerType.TEST -> "Test Name"
                ConsumerType.METHOD -> "Method Name"
            }
            1 -> "Energy (mJ)"
            else -> null
        }
    }

    override fun getColumnClass(var1: Int): Class<*>? = String::class.java

    override fun isCellEditable(var1: Int, var2: Int) = false

    override fun getValueAt(var1: Int, var2: Int): Any? {
        if (var2 == 0) return items[var1].consumer
        if (var2 == 1) return items[var1].energy
        return null
    }

    override fun setValueAt(var1: Any?, var2: Int, var3: Int) {}

    override fun addTableModelListener(var1: TableModelListener?) {}

    override fun removeTableModelListener(var1: TableModelListener?) {}
}