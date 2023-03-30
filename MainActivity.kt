package com.example.elementals

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Store unicodes of emojis of elements (fire, water, earth, wind)
        val elements1 = arrayOf(0x1F525, 0x1F4A6, 0x1F343, 0x1F4A8)
        val elements2 = arrayOf(0x1F525, 0x1F4A6, 0x1F343, 0x1F4A8)
        var elementsIndex1 = 0
        var elementsIndex2 = 0

        val element1 = findViewById<TextView>(R.id.element1)
        val element2 = findViewById<TextView>(R.id.element2)
        val result = findViewById<TextView>(R.id.text_result)
        val infobutton = findViewById(R.id.info) as ImageView

        // Change element for first button
        element1.setOnClickListener{
            elementsIndex1 += 1

            if (elementsIndex1 == 0){
                element1.setText(emojiUnicode(elements1[elementsIndex1]))
            }
            if (elementsIndex1 == 1){
                element1.setText(emojiUnicode(elements1[elementsIndex1]))
            }
            if (elementsIndex1 == 2){
                element1.setText(emojiUnicode(elements1[elementsIndex1]))
            }
            if (elementsIndex1 == 3){
                element1.setText(emojiUnicode(elements1[elementsIndex1]))
            }
            if (elementsIndex1 == 4){
                elementsIndex1 = 0
                element1.setText(emojiUnicode(elements1[elementsIndex1]))
            }

            displayResult(elementsIndex1, elementsIndex2, result)
        }

        // Change element for second button
        element2.setOnClickListener{
            elementsIndex2 += 1

            if (elementsIndex2 == 0){
                element2.setText(emojiUnicode(elements2[elementsIndex2]))
            }
            if (elementsIndex2 == 1){
                element2.setText(emojiUnicode(elements2[elementsIndex2]))
            }
            if (elementsIndex2 == 2){
                element2.setText(emojiUnicode(elements2[elementsIndex2]))
            }
            if (elementsIndex2 == 3){
                element2.setText(emojiUnicode(elements2[elementsIndex2]))
            }
            if (elementsIndex2 == 4){
                elementsIndex2 = 0
                element2.setText(emojiUnicode(elements1[elementsIndex2]))
            }

            displayResult(elementsIndex1, elementsIndex2, result)
        }

        // info button
        infobutton.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this)

            dialogBuilder.setMessage("Tap the one of the two buttons to change elements. Total of 10 unique elements are here. App made by Joel Dsouza.")
                .setCancelable(false)
                .setPositiveButton("OK", DialogInterface.OnClickListener {
                        dialog, id -> dialog.cancel()
                })

            val alert = dialogBuilder.create()

            alert.setTitle("Information")
            alert.show()
        }
    }

    // Function for result displaying after two current selected elements
    fun displayResult(elementsIndex1: Int, elementsIndex2: Int, result: TextView){
        if (elementsIndex1 == 0 && elementsIndex2 == 0){
            result.setText("LAVA")
            result.setTextColor(Color.parseColor("#FF0000"))
        }
        if (elementsIndex1 == 0 && elementsIndex2 == 1 || elementsIndex1 == 1 && elementsIndex2 == 0){
            result.setText("MELT")
            result.setTextColor(Color.parseColor("#0000FF"))
        }
        if (elementsIndex1 == 0 && elementsIndex2 == 2 || elementsIndex1 == 2 && elementsIndex2 == 0){
            result.setText("BURN")
            result.setTextColor(Color.parseColor("#B3B300"))
        }
        if (elementsIndex1 == 0 && elementsIndex2 == 3 || elementsIndex1 == 3 && elementsIndex2 == 0){
            result.setText("PYRONADO")
            result.setTextColor(Color.parseColor("#FFA500"))
        }

        if (elementsIndex1 == 1 && elementsIndex2 == 1){
            result.setText("TSUNAMI")
            result.setTextColor(Color.parseColor("#ADD8E6"))
        }
        if (elementsIndex1 == 1 && elementsIndex2 == 2 || elementsIndex1 == 2 && elementsIndex2 == 1){
            result.setText("GROWTH")
            result.setTextColor(Color.parseColor("#228B22"))
        }
        if (elementsIndex1 == 1 && elementsIndex2 == 3 || elementsIndex1 == 3 && elementsIndex2 == 1){
            result.setText("WHIRLPOOL")
            result.setTextColor(Color.parseColor("#000080"))
        }

        if (elementsIndex1 == 2 && elementsIndex2 == 2){
            result.setText("NATURE")
            result.setTextColor(Color.parseColor("#236F21"))
        }
        if (elementsIndex1 == 2 && elementsIndex2 == 3 || elementsIndex1 == 3 && elementsIndex2 == 2){
            result.setText("TORNADO")
            result.setTextColor(Color.parseColor("#5A5A5A"))
        }

        if (elementsIndex1 == 3 && elementsIndex2 == 3){
            result.setText("WINDY")
            result.setTextColor(Color.parseColor("#cabec0"))
        }
    }

    // Emoji Unicode Adder
    fun emojiUnicode(unicode: Int): String? {
        return String(Character.toChars(unicode))
    }
}