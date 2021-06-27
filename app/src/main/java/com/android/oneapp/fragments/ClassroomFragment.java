package com.android.oneapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.android.oneapp.R;
import com.android.oneapp.adapters.ClassroomModel;
import com.android.oneapp.adapters.ClassroomModelAdapter;

import java.util.ArrayList;


public class ClassroomFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView mRecyclerView;
    private ArrayList<ClassroomModel> mClassroomData;
    private ClassroomModelAdapter mAdapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public ClassroomFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ClassroomFragment newInstance(String param1, String param2) {
        ClassroomFragment fragment = new ClassroomFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        View view =  inflater.inflate(R.layout.fragment_classrooms, container, false);

        //Initialize the RecyclerView
        mRecyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);

        //Set the Layout Manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        //Initialize the ArrayLIst that will contain the data
        mClassroomData = new ArrayList<>();

        //Initialize the adapter and set it ot the RecyclerView
        mAdapter = new ClassroomModelAdapter(getActivity(), mClassroomData);
        mRecyclerView.setAdapter(mAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                1);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.divider));
        mRecyclerView.addItemDecoration(dividerItemDecoration);


        //Get the data
        initializeData();

        return view;
    }

    /**
     * Method for initializing the classrooms data from resources.
     */
    private void initializeData() {

        String[] nameList = getResources().getStringArray(R.array.member_names);
        String[] classroomInfo = getResources().getStringArray(R.array.classroom_info);

        mClassroomData.clear();
        for(int i=0;i<nameList.length;i++){
            mClassroomData.add(new ClassroomModel(nameList[i],classroomInfo[i]));
        }
        //Notify the adapter of the change
        mAdapter.notifyDataSetChanged();
    }


}