package com.google.gson.internal;

import android.support.v4.media.d;
import app.shamel.tv.models.EPGChannel;
import app.shamel.tv.models.MovieModel;
import app.shamel.tv.models.SeriesModel;
import io.realm.t;
import io.realm.u;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements ObjectConstructor, t {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f3919o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ String f3920p;

    public /* synthetic */ b(String str, int i10) {
        this.f3919o = i10;
        this.f3920p = str;
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        Object lambda$newUnsafeAllocator$20;
        Object lambda$newDefaultConstructor$7;
        Object lambda$newDefaultConstructor$8;
        Object lambda$get$2;
        Object lambda$get$3;
        Object lambda$get$4;
        switch (this.f3919o) {
            case 0:
                lambda$newUnsafeAllocator$20 = ConstructorConstructor.lambda$newUnsafeAllocator$20(this.f3920p);
                return lambda$newUnsafeAllocator$20;
            case 1:
                lambda$newDefaultConstructor$7 = ConstructorConstructor.lambda$newDefaultConstructor$7(this.f3920p);
                return lambda$newDefaultConstructor$7;
            case 2:
                lambda$newDefaultConstructor$8 = ConstructorConstructor.lambda$newDefaultConstructor$8(this.f3920p);
                return lambda$newDefaultConstructor$8;
            case 3:
                lambda$get$2 = ConstructorConstructor.lambda$get$2(this.f3920p);
                return lambda$get$2;
            case 4:
                lambda$get$3 = ConstructorConstructor.lambda$get$3(this.f3920p);
                return lambda$get$3;
            default:
                lambda$get$4 = ConstructorConstructor.lambda$get$4(this.f3920p);
                return lambda$get$4;
        }
    }

    @Override // io.realm.t
    public void e(u uVar) {
        switch (this.f3919o) {
            case 6:
                MovieModel movieModel = (MovieModel) d.j(uVar, MovieModel.class, "name", this.f3920p);
                if (movieModel != null) {
                    movieModel.setIs_favorite(true);
                    break;
                }
                break;
            case 7:
                SeriesModel seriesModel = (SeriesModel) d.j(uVar, SeriesModel.class, "name", this.f3920p);
                if (seriesModel != null) {
                    seriesModel.setIs_favorite(true);
                    break;
                }
                break;
            case 8:
                EPGChannel ePGChannel = (EPGChannel) d.j(uVar, EPGChannel.class, "name", this.f3920p);
                if (ePGChannel != null) {
                    ePGChannel.setIs_favorite(true);
                    break;
                }
                break;
            default:
                EPGChannel ePGChannel2 = (EPGChannel) d.j(uVar, EPGChannel.class, "name", this.f3920p);
                if (ePGChannel2 != null) {
                    ePGChannel2.setIs_locked(true);
                    break;
                }
                break;
        }
    }
}
