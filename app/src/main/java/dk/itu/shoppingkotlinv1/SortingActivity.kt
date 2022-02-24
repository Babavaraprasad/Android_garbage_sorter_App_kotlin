package dk.itu.shoppingkotlinv1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SortingActivity : AppCompatActivity() {
    // GUI variables
    private lateinit var addpage: Button
    private lateinit var placeofitem: Button
    private lateinit var inputcontent:EditText

    // Model: Database of items
    private lateinit var itemsDB: ItemsDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.garbagesorting)

        ItemsDB.initialize()
        itemsDB = ItemsDB.get()

        //Text Fields
        inputcontent= findViewById(R.id.Enter_text);
        placeofitem = findViewById(R.id.where_button)
        placeofitem.setOnClickListener {
            //fun onClick(view: View?) {
                val name: String = inputcontent.getText().toString()
                Log.d("ItemsDB", "search what: $name")
                inputcontent.setText(this.itemsDB.search(name))
            //}
        }

        //add page activity starts here
        addpage = findViewById(R.id.add_new_btn)
        addpage.setOnClickListener {
            val intent = Intent(this, AddPage::class.java)
            startActivity(intent)
        }
        //



    }
}