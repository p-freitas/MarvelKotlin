package com.marvelapp.br.ui

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.view.MenuItemCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.marvelapp.br.R
import com.marvelapp.br.adapter.PersonagemQuadrinhosAdapter
import com.marvelapp.br.viewmodel.PersonagemViewModel
import kotlinx.android.synthetic.main.fragment_personagem_detalhe.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PersonagemQuadrinhosFragment : Fragment() {

    private val viewModel: PersonagemViewModel by viewModel()
    private lateinit var adapter: PersonagemQuadrinhosAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        return inflater.inflate(R.layout.fragment_personagem_detalhe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       recycler_comics.layoutManager = LinearLayoutManager(requireContext())

       viewModel.getComics(this.arguments?.getInt("id")!!)
        viewModel.personagemDetalheLiveData.observeForever {
            adapter = PersonagemQuadrinhosAdapter(it.data.results, ::openURL)
            recycler_comics.adapter = adapter
        }
    }


    private fun openURL(url: String) {
        startActivity(Intent(ACTION_VIEW, Uri.parse(url)))
    }
}
