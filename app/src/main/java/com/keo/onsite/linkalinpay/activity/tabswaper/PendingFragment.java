package com.keo.onsite.linkalinpay.activity.tabswaper;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.keo.onsite.linkalinpay.R;
import com.keo.onsite.linkalinpay.activity.Recyclerviewmargin;
import com.keo.onsite.linkalinpay.activity.model.Myordermodelclass;
import com.keo.onsite.linkalinpay.adapter.Myorderadapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PendingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PendingFragment extends Fragment {
    public final static String ITEMS_COUNT_KEY = "PartfiveFragment$ItemsCount";
    RecyclerView recyclerView;
    View rootView;
    private static ArrayList<Myordermodelclass> Dataitem1;
    static PendingFragment partfiveFragment;
   View view;
    Myorderadapter madapter;


   // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PendingFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static PendingFragment newInstance(int itemsCount, ArrayList<Myordermodelclass> Dataitem, String flag) {
        partfiveFragment = new PendingFragment();

        Bundle bundle = new Bundle();
        // bundle.putInt(ITEMS_COUNT_KEY, itemsCount);
        bundle.putString(ITEMS_COUNT_KEY, flag);
        partfiveFragment.setArguments(bundle);
        Dataitem1=Dataitem;
        return partfiveFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_pending, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
       // recyclerView.setHasFixedSize(true);
        // LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
       // LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
       // recyclerView.setLayoutManager(layoutManager);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        Recyclerviewmargin itemdecorator=new Recyclerviewmargin(20);
        recyclerView.addItemDecoration(itemdecorator);

        madapter = new Myorderadapter(getActivity(), Dataitem1);
        recyclerView.setAdapter(madapter);




        return view;
    }
}