package com.example.tabbedactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MoviesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = MoviesAdapter(getMoviesList(arguments?.getString(ARG_GENRE)))
        recyclerView.adapter = adapter
        return view
    }

    companion object {
        private const val ARG_GENRE = "genre"

        fun newInstance(genre: String): MoviesFragment {
            val fragment = MoviesFragment()
            val args = Bundle()
            args.putString(ARG_GENRE, genre)
            fragment.arguments = args
            return fragment
        }
    }

    private fun getMoviesList(genre: String?): List<Movie> {
        return when (genre) {
            "Боевик" -> listOf(
                Movie("Темный рыцарь", "Рейтинг критиков: 9.0", R.drawable.dark_knight),
                Movie("Крепкий орешек", "Рейтинг критиков: 8.0", R.drawable.die_hard),
                Movie("Матрица", "Рейтинг критиков: 8.5", R.drawable.matrix)
            )
            "Комедия" -> listOf(
                Movie("Иван Васильевич меняет профессию", "Рейтинг критиков: 7.5", R.drawable.ivan),
                Movie("Тупой и ещё тупее", "Рейтинг критиков: 9.0", R.drawable.dumb_and_dumber),
                Movie("Криминальное чтиво", "Рейтинг критиков: 8.5", R.drawable.pulp_fiction)
            )
            "Драма" -> listOf(
                Movie("Зеленая миля", "Рейтинг критиков: 8.9", R.drawable.green_mile),
                Movie("Побег из Шоушенка", "Рейтинг критиков: 9.3", R.drawable.shawshank),
                Movie("Престиж", "Рейтинг критиков: 8.8", R.drawable.prestige)
            )
            else -> emptyList()
        }
    }
}
