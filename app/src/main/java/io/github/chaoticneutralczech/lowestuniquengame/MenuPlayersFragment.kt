package io.github.chaoticneutralczech.lowestuniquengame

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import io.github.chaoticneutralczech.lowestuniquengame.R as eRko
import android.util.Log


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MenuPlayersFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenuPlayersFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(eRko.layout.fragment_menu_players, container, false)
        val inviteIntent = Intent(activity, InviteActivity::class.java)
        //inviteIntent.putExtra("strIP", strIP)
        //val aview = inflater.inflate(eRko.layout.fragment_menu_players, container, false) as View
        val inviteButton =  rootView.findViewById(eRko.id.invitebutton) as Button

        Log.d("Button", inviteButton.toString())
        inviteButton!!.isClickable = true
        inviteButton!!.setOnClickListener {rootView ->
            Log.d("Press!", inviteButton.toString())
            requireActivity().startActivity(inviteIntent)

        }


        requireActivity().startActivity(inviteIntent)
        //return inflater.inflate(eRko.layout.fragment_menu_players, container, false)
        return rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MenuPlayersFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MenuPlayersFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}