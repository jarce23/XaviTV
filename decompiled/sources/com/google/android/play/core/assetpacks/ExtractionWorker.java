package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.media.session.a0;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import j9.h0;
import j9.h1;
import j9.j0;
import j9.k0;
import j9.u0;
import k9.e;
import o4.f;
import o4.g;
import o4.k;
import o4.m;
import o4.n;
import x4.c;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class ExtractionWorker extends Worker {

    /* renamed from: t, reason: collision with root package name */
    public final h0 f3905t;

    public ExtractionWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.f3905t = (h0) ((e) k0.c(context).f13565q).c();
    }

    @Override // androidx.work.Worker
    public final n f() {
        f fVar = this.f9507p.f1519b;
        h0 h0Var = this.f3905t;
        h0Var.getClass();
        a0 a0Var = new a0("session_bundle:", fVar);
        k0.h(a0Var);
        Bundle bundle = (Bundle) a0Var.f232r;
        try {
            u0 u0Var = h0Var.f7298a;
            u0Var.getClass();
            if (((Boolean) u0Var.b(new c(u0Var, 9, bundle))).booleanValue()) {
                h0Var.f7299b.a();
            }
            return new m(f.f9497c);
        } catch (j0 e7) {
            h0.f7297d.f("Error while updating ExtractorSessionStoreView: %s", e7.getMessage());
            return new k();
        }
    }

    @Override // androidx.work.Worker
    public final g g() {
        f fVar = this.f9507p.f1519b;
        h1 h1Var = this.f3905t.f7300c;
        a0 a0Var = new a0("notification_bundle:", fVar);
        k0.g(a0Var);
        Bundle bundle = (Bundle) a0Var.f232r;
        h1Var.b(bundle);
        return new g(-1883842196, h1Var.a(bundle), 0);
    }
}
