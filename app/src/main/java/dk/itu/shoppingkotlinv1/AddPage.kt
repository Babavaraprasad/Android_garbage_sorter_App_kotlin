package dk.itu.shoppingkotlinv1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddPage: AppCompatActivity() {
    private lateinit var itemsDB: ItemsDB
    private lateinit var addItemtodb: Button
    private lateinit var newWhat: TextView
    private lateinit var newWhere: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addnewitem)

        //add activity starts here
        ItemsDB.initialize()
        itemsDB = ItemsDB.get()
        newWhat = findViewById(R.id.what_text)
        newWhere = findViewById(R.id.where_text)
        addItemtodb = findViewById(R.id.add_button)
        addItemtodb.setOnClickListener {
            val whatS = newWhat.text.toString().trim()
            val whereS = newWhere.text.toString().trim()
            if ((whatS.length > 0) && (whereS.length > 0)) {
                itemsDB.addItem(whatS, whereS)
                newWhat.text = ""
                newWhere.text = ""
            } else {
                Toast.makeText(this, "Not valid", Toast.LENGTH_LONG).show();
            }
        }

       //add activity ends here
    }
}