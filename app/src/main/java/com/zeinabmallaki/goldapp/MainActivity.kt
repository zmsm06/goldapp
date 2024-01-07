package com.zeinabmallaki.goldapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zeinabmallaki.goldapp.databinding.ActivityMainBinding
import com.zeinabmallaki.goldapp.remote.dataModel.dataModel.ContentModel
import com.zeinabmallaki.goldapp.remote.dataModel.dataModel.DateModel
import com.zeinabmallaki.goldapp.remote.dataModel.dataModel.GoldModel
import com.zeinabmallaki.goldapp.remote.golds.GoldApiRepository
import com.zeinabmallaki.goldapp.remote.golds.GoldRequest
import com.zeinabmallaki.goldapp.remote.time.TimeApiRepository
import com.zeinabmallaki.goldapp.remote.time.TimeRequest

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val goldPrice = ArrayList<ContentModel>()
    private val currencyPrice = ArrayList<ContentModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        TimeApiRepository.instance.getTime(

            object : TimeRequest {
                override fun onSuccess(data: DateModel) {
                    val date = data.date
                    val text = "${date.l_value} ${date.j_value} ${date.F_value} ${date.Y_value}"
                    binding.txtTime.text = text

                }

                override fun onNotSuccess(message: String) {
                    Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()

                }

                override fun onError(error: String) {
                    Toast.makeText(this@MainActivity, error, Toast.LENGTH_SHORT).show()

                }

            }
        )

        binding.txtArz.setOnClickListener {

            binding.txtArz.setTextColor(Color.parseColor("#E7C376"))
            binding.txtTala.setTextColor(Color.parseColor("#787879"))

            setData(currencyPrice)



        }

        binding.txtTala.setOnClickListener {

            binding.txtArz.setTextColor(Color.parseColor("#787879"))
            binding.txtTala.setTextColor(Color.parseColor("#E7C376"))

            setData(goldPrice)

        }

        getPrice()

        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)


    }



    private fun getPrice(){
        GoldApiRepository.instance.getGolds(
            object : GoldRequest{
                override fun onSuccess(data: GoldModel) {

                    goldPrice.addAll(data.data.golds)
                    currencyPrice.addAll(data.data.currencies)
                    setData(goldPrice) }

                override fun onNotSuccess(message: String) {}

                override fun onError(error: String) {}
            }
        )
    }

    private fun setData(data:ArrayList<ContentModel>){

        binding.recyclerView.adapter = RecyclerMainAdapter(data)
    }
}