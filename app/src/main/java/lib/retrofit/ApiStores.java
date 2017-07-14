package lib.retrofit;


import com.lsy.hebao.ui.actvity.sign.bean.UsersBody;
import com.lsy.hebao.ui.actvity.sign.model.Register;
import com.lsy.hebao.ui.actvity.sign.model.Users;
import com.lsy.hebao.ui.fragment.invse.One.model.OneAll;
import com.lsy.hebao.ui.fragment.invse.Two.model.TwoAll;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;

public interface ApiStores {
    //baseUrl
   // String API_SERVER_URL = "http://101.200.86.204:8000/api/";
    String API_SERVER_URL=" https://t.91tianmi.com/";
    //String API_SERVER_URL=" https://www.91tianmi.com/";
    //定存宝产品信息
    @GET("api/products/dcb/")
    Observable<OneAll> loadDataOne();
    //所有的产品信息
    @GET("api/products/mobile")
    Observable<TwoAll> loadDataTwo();
    //兑换积分
    @FormUrlEncoded
    @POST("api/users/sms/register/")
    Observable<Register> loadDataregister(@Field("mobile") String mobile);

    @FormUrlEncoded
    @POST("api/users/register/")
    Observable<Users> loadDatausers(@Field("username") String username,@Field("sms_code") String sms_code,@Field("nick_name") String nick_name,@Field("password") String password );
}
