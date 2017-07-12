package lib.retrofit;


import com.lsy.hebao.ui.fragment.invse.One.model.OneAll;
import com.lsy.hebao.ui.fragment.invse.Two.model.TwoAll;

import retrofit2.http.GET;
import rx.Observable;

public interface ApiStores {
    //baseUrl
    String API_SERVER_URL = "http://101.200.86.204:8000/api/";
    //定存宝产品信息
    @GET("products/dcb/")
    Observable<OneAll> loadDataOne();
    //所有的产品信息
    @GET("products/mobile")
    Observable<TwoAll> loadDataTwo();
}
