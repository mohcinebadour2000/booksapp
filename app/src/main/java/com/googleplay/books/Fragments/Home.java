package com.googleplay.books.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.googleplay.books.Book;
import com.googleplay.books.R;
import com.googleplay.books.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    List<Book> lsBook;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        lsBook = new ArrayList<>();
        lsBook.add(new Book("Book 1","Category 1","Desc 1",R.drawable.book1));
        lsBook.add(new Book("Book 2","Category 2","Desc 2",R.drawable.book2));
        lsBook.add(new Book("Book 3","Category 3","Desc 3",R.drawable.book3));
        lsBook.add(new Book("Book 4","Category 4","Desc 4",R.drawable.book4));
        lsBook.add(new Book("Book 5","Category 5","Desc 5",R.drawable.book5));
        lsBook.add(new Book("Book 6","Category 6","Desc 6",R.drawable.book6));
        lsBook.add(new Book("Book 7","Category 7","Desc 7",R.drawable.book7));
        lsBook.add(new Book("Book 8","Category 8","Desc 8",R.drawable.book8));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_id);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(),lsBook);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        recyclerView.setAdapter(adapter);


        // Inflate the layout for this fragment
        return view;
    }


}