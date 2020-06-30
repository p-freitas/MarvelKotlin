package com.marvelapp.br.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.marvelapp.br.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.personagem_comic_list_item.view.*

class PersonagemQuadrinhosAdapter(
    private val list: List<com.marvelapp.br.sdk.response.Result>,
    private val openURL: (url: String) -> Unit
) : RecyclerView.Adapter<PersonagemQuadrinhosAdapter.VH>(), Filterable {

    var filteredList: List<com.marvelapp.br.sdk.response.Result>
        init {
            filteredList = list
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VH {
        return VH(
            LayoutInflater.from(parent.context).inflate(
                R.layout.personagem_comic_list_item,
                parent,
                false
            ),
            openURL
        )
    }

    override fun getItemCount(): Int {
        return filteredList!!.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(filteredList[position])

    }

    class VH(
        itemView: View,
        private val openURL: (url: String) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        private val comic_image = itemView.comic_item_img
        private val comic_name = itemView.comic_item_title
        private val comic_description = itemView.comic_item_description

        fun bind(item: com.marvelapp.br.sdk.response.Result) {
            Picasso.get().load("${item.thumbnail.path}.${item.thumbnail.extension}").fit()
                .centerCrop().into(comic_image)
            comic_name.text = item.name
            if (item.description != null && item.description.isNotEmpty()){
                comic_description.text = item.description
            }else{
                comic_description.text = "Descrição ausente"
            }
        }

    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                if(constraint.toString().isNotEmpty()) {
                  filteredList =
                      list?.filter {  it.name.toUpperCase().contains(constraint.toString().toUpperCase())}
                } else {
                    filteredList = list
                }
                val filterResults = FilterResults()
                filterResults.values = filteredList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredList = results?.values as List<com.marvelapp.br.sdk.response.Result>
                notifyDataSetChanged()
            }
        }
    }
}