package com.gd.gd10_b_10774

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gd.gd10_b_10774.DetailMahasiswaActivity
import com.gd.gd10_b_10774.databinding.ListDataMahasiswaBinding
import com.google.gson.annotations.SerializedName

class MahasiswaAdapter (
    private val listMahasiswa:ArrayList<MahasiswaData>,
    private val context: Context

):RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>() {
    inner class
    MahasiswaViewHolder(item: ListDataMahasiswaBinding): RecyclerView.ViewHolder(item.root){
        private val binding = item
        fun bind(mahasiswaData: MahasiswaData){
            with(binding) {
                txtNim.text = mahasiswaData.nim
                txtNama.text = mahasiswaData.nama
                cvData.setOnClickListener {
                    var i = Intent(context,
                        DetailMahasiswaActivity::class.java).apply {
                        putExtra("nim",mahasiswaData.nim)
                    }
                    context.startActivity(i)
                }
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType:
    Int): MahasiswaViewHolder {
        return MahasiswaViewHolder(
            ListDataMahasiswaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,false
            ))
    }
    override fun onBindViewHolder(holder: MahasiswaViewHolder,
                                  position: Int) {
        holder.bind(listMahasiswa[position])
    }
    override fun getItemCount(): Int = listMahasiswa.size
}