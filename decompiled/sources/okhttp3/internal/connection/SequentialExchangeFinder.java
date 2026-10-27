package okhttp3.internal.connection;

import com.bumptech.glide.f;
import java.io.IOException;
import okhttp3.internal.connection.RoutePlanner;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class SequentialExchangeFinder implements ExchangeFinder {
    private final RoutePlanner routePlanner;

    public SequentialExchangeFinder(RoutePlanner routePlanner) {
        h.e("routePlanner", routePlanner);
        this.routePlanner = routePlanner;
    }

    @Override // okhttp3.internal.connection.ExchangeFinder
    public RealConnection find() {
        RoutePlanner.Plan plan;
        IOException iOException = null;
        while (!getRoutePlanner().isCanceled()) {
            try {
                plan = getRoutePlanner().plan();
            } catch (IOException e7) {
                if (iOException == null) {
                    iOException = e7;
                } else {
                    f.a(iOException, e7);
                }
                if (!a.a(getRoutePlanner(), null, 1, null)) {
                    throw iOException;
                }
            }
            if (!plan.isReady()) {
                RoutePlanner.ConnectResult mo149connectTcp = plan.mo149connectTcp();
                if (mo149connectTcp.isSuccess()) {
                    mo149connectTcp = plan.mo150connectTlsEtc();
                }
                RoutePlanner.Plan component2 = mo149connectTcp.component2();
                Throwable component3 = mo149connectTcp.component3();
                if (component3 != null) {
                    throw component3;
                }
                if (component2 != null) {
                    getRoutePlanner().getDeferredPlans().addFirst(component2);
                }
            }
            return plan.mo146handleSuccess();
        }
        throw new IOException("Canceled");
    }

    @Override // okhttp3.internal.connection.ExchangeFinder
    public RoutePlanner getRoutePlanner() {
        return this.routePlanner;
    }
}
