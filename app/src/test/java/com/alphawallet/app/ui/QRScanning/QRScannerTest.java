package com.alphawallet.app.ui.QRScanning;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

import com.alphawallet.shadows.ShadowRealm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;

@RunWith(RobolectricTestRunner.class)
@Config(shadows = {ShadowRealm.class}, application = TestApplication.class)
public class QRScannerTest
{

    @Test
    @Config(sdk = 23)
    public void given_api_23_when_onCreate_then_notify_feature_not_supported()
    {
        try (ActivityScenario<QRScanner> scenario = ActivityScenario.launch(QRScanner.class))
        {
            assertThat(scenario.getState(), equalTo(Lifecycle.State.DESTROYED));
            assertThat(ShadowToast.getTextOfLatestToast(), equalTo("QR scanning requires Android 7.0 (API level 24) or above."));
        }
    }
}
