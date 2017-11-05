package sky.oder.http;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author sky
 * @version 1.0 on 2017-11-03 上午9:48
 * @see GithubHttp github 公开接口
 */
public interface GithubHttp {

	@GET("rate_limit") Call<Object> rateLimit();


}
