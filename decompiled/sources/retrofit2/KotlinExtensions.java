package retrofit2;

import com.google.android.gms.internal.cast.n;
import ib.e;
import ib.f;
import la.b;
import la.i;
import pa.d;
import ya.l;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class KotlinExtensions {
    public static final <T> Object await(final Call<T> call, d<? super T> dVar) {
        final f fVar = new f(1, a.a.m(dVar));
        fVar.o();
        fVar.q(new ib.d(new l() { // from class: retrofit2.KotlinExtensions$await$2$1
            @Override // ya.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return i.f8335a;
            }

            public final void invoke(Throwable th) {
                call.cancel();
            }
        }));
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$await$2$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable th) {
                h.e("call", call2);
                h.e("t", th);
                ((f) e.this).resumeWith(n.d(th));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                h.e("call", call2);
                h.e("response", response);
                if (!response.isSuccessful()) {
                    ((f) e.this).resumeWith(n.d(new HttpException(response)));
                    return;
                }
                T body = response.body();
                if (body != null) {
                    ((f) e.this).resumeWith(body);
                    return;
                }
                Object tag = call2.request().tag(Invocation.class);
                h.b(tag);
                Invocation invocation = (Invocation) tag;
                ((f) e.this).resumeWith(n.d(new b("Response from " + invocation.service().getName() + '.' + invocation.method().getName() + " was null but response body type was declared as non-null")));
            }
        });
        Object n10 = fVar.n();
        qa.a aVar = qa.a.f10374o;
        return n10;
    }

    public static final <T> Object awaitNullable(final Call<T> call, d<? super T> dVar) {
        final f fVar = new f(1, a.a.m(dVar));
        fVar.o();
        fVar.q(new ib.d(new l() { // from class: retrofit2.KotlinExtensions$await$4$1
            @Override // ya.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return i.f8335a;
            }

            public final void invoke(Throwable th) {
                call.cancel();
            }
        }));
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$await$4$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable th) {
                h.e("call", call2);
                h.e("t", th);
                ((f) e.this).resumeWith(n.d(th));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                h.e("call", call2);
                h.e("response", response);
                if (response.isSuccessful()) {
                    ((f) e.this).resumeWith(response.body());
                } else {
                    ((f) e.this).resumeWith(n.d(new HttpException(response)));
                }
            }
        });
        Object n10 = fVar.n();
        qa.a aVar = qa.a.f10374o;
        return n10;
    }

    public static final <T> Object awaitResponse(final Call<T> call, d<? super Response<T>> dVar) {
        final f fVar = new f(1, a.a.m(dVar));
        fVar.o();
        fVar.q(new ib.d(new l() { // from class: retrofit2.KotlinExtensions$awaitResponse$2$1
            @Override // ya.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return i.f8335a;
            }

            public final void invoke(Throwable th) {
                call.cancel();
            }
        }));
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$awaitResponse$2$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable th) {
                h.e("call", call2);
                h.e("t", th);
                ((f) e.this).resumeWith(n.d(th));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                h.e("call", call2);
                h.e("response", response);
                e.this.resumeWith(response);
            }
        });
        Object n10 = fVar.n();
        qa.a aVar = qa.a.f10374o;
        return n10;
    }

    public static final Object awaitUnit(Call<i> call, d<? super i> dVar) {
        h.c("null cannot be cast to non-null type retrofit2.Call<kotlin.Unit?>", call);
        return awaitNullable(call, dVar);
    }

    public static final <T> T create(Retrofit retrofit) {
        h.e("<this>", retrofit);
        throw new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object suspendAndThrow(final java.lang.Throwable r4, pa.d<?> r5) {
        /*
            boolean r0 = r5 instanceof retrofit2.KotlinExtensions$suspendAndThrow$1
            if (r0 == 0) goto L13
            r0 = r5
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = (retrofit2.KotlinExtensions$suspendAndThrow$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = new retrofit2.KotlinExtensions$suspendAndThrow$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            qa.a r1 = qa.a.f10374o
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 == r3) goto L2b
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2b:
            java.lang.Object r4 = r0.L$0
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            com.google.android.gms.internal.cast.n.t(r5)
            a6.m0 r4 = new a6.m0
            r4.<init>()
            throw r4
        L38:
            com.google.android.gms.internal.cast.n.t(r5)
            r0.L$0 = r4
            r0.label = r3
            pb.e r5 = ib.a0.f6541a
            pa.i r2 = r0.getContext()
            retrofit2.KotlinExtensions$suspendAndThrow$2$1 r3 = new retrofit2.KotlinExtensions$suspendAndThrow$2$1
            r3.<init>()
            r5.M(r2, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.KotlinExtensions.suspendAndThrow(java.lang.Throwable, pa.d):java.lang.Object");
    }
}
