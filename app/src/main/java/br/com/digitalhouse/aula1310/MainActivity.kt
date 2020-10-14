package br.com.digitalhouse.aula1310

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Instânciando a toolbar
        setSupportActionBar(toolbar)

        //Evento click navigation
        toolbar.setNavigationOnClickListener() {
            Log.i(TAG, "Clincando no navigationbar")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var itemView = item.itemId
        when(itemView){
//            R.id.menu_add -> Log.i(TAG, "Adicionando")
//            R.id.menu_notification -> Log.i(TAG, "Notificação")
//            R.id.menu_add -> showToast("Adicionando")
//            R.id.menu_notification -> showToast("Notificação")
            R.id.menu_add -> showSnackbar("Adicionando")
            R.id.menu_notification -> showSnackbar("Notificação")

        }
        return false
    }

    fun showToast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun showSnackbar(msg: String){
        var snack = Snackbar.make(snack_layout, msg, Snackbar.LENGTH_SHORT)
        snack.setAction("ok", View.OnClickListener{
            Log.i(TAG, "Clicando em ok")
        })

        snack.setAnchorView(floatingActionButton)
        //ou snack.anchorView = floatingActionButton
        snack.show()
    }
}