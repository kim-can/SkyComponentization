package sky.common.glide;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

/**
 * @author sky
 * @version 1.0 on 2017-12-02 下午9:21
 * @see MyAppGlideModule
 */
@GlideModule
public final class MyAppGlideModule extends AppGlideModule {

	@Override public boolean isManifestParsingEnabled() {
		return false;
	}
}