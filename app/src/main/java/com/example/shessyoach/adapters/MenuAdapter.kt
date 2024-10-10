import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shessyoach.R
import com.example.shessyoach.data_control.MenuItems
import com.example.shessyoach.activities.*
import com.example.shessyoach.data_control.Player
import com.example.shessyoach.helpers.NotificationHelper

class MenuAdapter(
    private val context: Context,
    private val menuItems: MenuItems
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    inner class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.findViewById(R.id.menu_icon)
        val title: TextView = itemView.findViewById(R.id.menu_title)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val menuItem = menuItems.menus[position]
                    if (menuItem.isOnline && !Player.current.isLogged) {

                    }else{
                        startCorrespondingActivity(menuItem.activityClass) // Используем activityClass
                    }
                }
            }
        }

        private fun startCorrespondingActivity(activityClass: Class<*>) {
            val intent = Intent(context, activityClass)
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.menu_ui_element, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val menuItem = menuItems.menus[position]
        holder.icon.setImageResource(menuItem.iconResId)
        holder.title.text = menuItem.title

        // Проверяем доступность и изменяем внешний вид элемента
        if (menuItem.isOnline && !Player.current.isLogged) {
            holder.itemView.alpha = 0.5f // Уменьшаем яркость для недоступных элементов
            holder.itemView.isClickable = false // Элемент недоступен для нажатия
        } else {
            holder.itemView.alpha = 1.0f // Полная яркость для доступных элементов
            holder.itemView.isClickable = true // Элемент доступен для нажатия
        }
    }

    override fun getItemCount() = menuItems.menus.size
}
