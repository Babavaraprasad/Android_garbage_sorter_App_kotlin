package dk.itu.shoppingkotlinv1

import android.content.Context
import android.util.Log
import java.lang.IllegalStateException
import java.util.ArrayList

class ItemsDB private constructor(){
    private val itemsMap:HashMap<String,String> = HashMap<String,String>()
    init { fillItemsDB()}
    companion object {
        private var sItemsDB: ItemsDB? = null

        fun initialize() {
            if (sItemsDB == null) {
                sItemsDB = ItemsDB()
            }
        }
        fun get(): ItemsDB {
            return sItemsDB ?:
                throw IllegalStateException("ItemsDB must be initializes")
        }
    }

    fun listItems(): String {
        var r = ""
        for ((key, value) in itemsMap)
            r = "$r\n Buy $key in: $value"
        return r
    }

    fun size(): Int {
        return itemsMap.size
    }
    fun getWhere(what: String): String? {
        return itemsMap[what]
    }

    fun addItem(what: String, where: String) {
        itemsMap[what] = where
    }

    fun removeItem(what: String) {
        if (itemsMap[what] != null) itemsMap.remove(what)
    }

    private fun fillItemsDB() {
        itemsMap.put("coffee", "Irma")
        itemsMap.put("carrots", "Netto")
        itemsMap.put("milk", "Netto")
        itemsMap.put("bread", "bakery")
        itemsMap.put("butter", "Irma")
    }

    //search functionality
    open fun search(query: String?): String? {
        var result = ""
        if (query != null) {
            result = if (itemsMap.containsKey(query)) {
                val wherevalue = getWhere(query)
                Log.d("ItemsDB", "search what: $wherevalue")
                "$query should be placed in: $wherevalue"
            } else {
                "$query should be placed in: not found"
            }
        }
        return result
    }
    //search functionality ends

}