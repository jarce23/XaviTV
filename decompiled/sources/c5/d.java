package c5;

import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import app.shamel.tv.activities.mobile.LiveChannelMobileActivity;
import app.shamel.tv.activities.mobile.LiveMobileActivity;
import app.shamel.tv.activities.mobile.MovieMobilePlayer;
import app.shamel.tv.activities.mobile.SeriesMobilePlayer;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2929a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f.j f2930b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(f.j jVar, Handler handler, int i10) {
        super(handler);
        this.f2929a = i10;
        this.f2930b = jVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z10) {
        switch (this.f2929a) {
            case 0:
                super.onChange(z10);
                LiveChannelMobileActivity liveChannelMobileActivity = (LiveChannelMobileActivity) this.f2930b;
                AudioManager audioManager = liveChannelMobileActivity.N;
                if (audioManager != null && liveChannelMobileActivity.O0 != null) {
                    liveChannelMobileActivity.O0.setProgress(audioManager.getStreamVolume(3));
                    break;
                }
                break;
            case 1:
                super.onChange(z10);
                LiveMobileActivity liveMobileActivity = (LiveMobileActivity) this.f2930b;
                AudioManager audioManager2 = liveMobileActivity.N;
                if (audioManager2 != null && liveMobileActivity.P0 != null) {
                    liveMobileActivity.P0.setProgress(audioManager2.getStreamVolume(3));
                    break;
                }
                break;
            case 2:
                super.onChange(z10);
                MovieMobilePlayer movieMobilePlayer = (MovieMobilePlayer) this.f2930b;
                AudioManager audioManager3 = movieMobilePlayer.M;
                if (audioManager3 != null && movieMobilePlayer.f1998r0 != null) {
                    movieMobilePlayer.f1998r0.setProgress(audioManager3.getStreamVolume(3));
                    break;
                }
                break;
            default:
                super.onChange(z10);
                SeriesMobilePlayer seriesMobilePlayer = (SeriesMobilePlayer) this.f2930b;
                AudioManager audioManager4 = seriesMobilePlayer.M;
                if (audioManager4 != null && seriesMobilePlayer.O != null) {
                    seriesMobilePlayer.O.setProgress(audioManager4.getStreamVolume(3));
                    break;
                }
                break;
        }
    }
}
