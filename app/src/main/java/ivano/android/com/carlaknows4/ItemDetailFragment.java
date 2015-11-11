package ivano.android.com.carlaknows4;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import ivano.android.com.carlaknows4.dummy.DummyContent;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {


    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        if (mMap == null) {
//            // Try to obtain the map from the SupportMapFragment.
//            //http://stackoverflow.com/questions/18611936/android-googlemap-or-supportmapfragment-null-pointer-exception
//            //https://www.google.nl/search?q=SupportMapFragment+nullpointerexception&sourceid=ie7&rls=com.microsoft:en-US:IE-Address&ie=&oe=&gfe_rd=cr&ei=lO43VpjrLuWI8Qeam5_gAg
//            mMap = ((SupportMapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
//            MapFragment mapFragment = (MapFragment) getActivity().getFragmentManager()
//                    .findFragmentById(R.id.map);
//            mapFragment.getMapAsync((OnMapReadyCallback) getActivity());
//
//
//
//
////            FragmentManager fm = getChildFragmentManager();
////          SupportMapFragment  mapFragment = (SupportMapFragment) fm.findFragmentById(R.id.map);
////            mapFragment.getMapAsync(new OnMapReadyCallback() {
////                public void onMapReady(GoogleMap googleMap) {
////                    mMap = googleMap;
////                }
////            });
//
//     // Check if we were successful in obtaining the map.
//           if (mMap != null) {
//                mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
//
//            }
//        }
        View rootView = inflater.inflate(R.layout.fragment_item_detail, container, false);



        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.item_detail)).setText(mItem.content);
        }

        return rootView;
    }
}
