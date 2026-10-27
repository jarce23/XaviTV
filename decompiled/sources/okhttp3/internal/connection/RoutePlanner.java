package okhttp3.internal.connection;

import ma.h;
import okhttp3.Address;
import okhttp3.HttpUrl;
import za.e;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public interface RoutePlanner {

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class DefaultImpls {
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public interface Plan {
        /* renamed from: cancel */
        void mo145cancel();

        /* renamed from: connectTcp */
        ConnectResult mo149connectTcp();

        /* renamed from: connectTlsEtc */
        ConnectResult mo150connectTlsEtc();

        /* renamed from: handleSuccess */
        RealConnection mo146handleSuccess();

        boolean isReady();

        /* renamed from: retry */
        Plan mo147retry();
    }

    Address getAddress();

    h getDeferredPlans();

    boolean hasNext(RealConnection realConnection);

    boolean isCanceled();

    Plan plan();

    boolean sameHostAndPort(HttpUrl httpUrl);

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class ConnectResult {
        private final Plan nextPlan;
        private final Plan plan;
        private final Throwable throwable;

        public ConnectResult(Plan plan, Plan plan2, Throwable th) {
            za.h.e("plan", plan);
            this.plan = plan;
            this.nextPlan = plan2;
            this.throwable = th;
        }

        public static /* synthetic */ ConnectResult copy$default(ConnectResult connectResult, Plan plan, Plan plan2, Throwable th, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                plan = connectResult.plan;
            }
            if ((i10 & 2) != 0) {
                plan2 = connectResult.nextPlan;
            }
            if ((i10 & 4) != 0) {
                th = connectResult.throwable;
            }
            return connectResult.copy(plan, plan2, th);
        }

        public final Plan component1() {
            return this.plan;
        }

        public final Plan component2() {
            return this.nextPlan;
        }

        public final Throwable component3() {
            return this.throwable;
        }

        public final ConnectResult copy(Plan plan, Plan plan2, Throwable th) {
            za.h.e("plan", plan);
            return new ConnectResult(plan, plan2, th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ConnectResult)) {
                return false;
            }
            ConnectResult connectResult = (ConnectResult) obj;
            return za.h.a(this.plan, connectResult.plan) && za.h.a(this.nextPlan, connectResult.nextPlan) && za.h.a(this.throwable, connectResult.throwable);
        }

        public final Plan getNextPlan() {
            return this.nextPlan;
        }

        public final Plan getPlan() {
            return this.plan;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }

        public int hashCode() {
            int hashCode = this.plan.hashCode() * 31;
            Plan plan = this.nextPlan;
            int hashCode2 = (hashCode + (plan == null ? 0 : plan.hashCode())) * 31;
            Throwable th = this.throwable;
            return hashCode2 + (th != null ? th.hashCode() : 0);
        }

        public final boolean isSuccess() {
            return this.nextPlan == null && this.throwable == null;
        }

        public String toString() {
            return "ConnectResult(plan=" + this.plan + ", nextPlan=" + this.nextPlan + ", throwable=" + this.throwable + ')';
        }

        public /* synthetic */ ConnectResult(Plan plan, Plan plan2, Throwable th, int i10, e eVar) {
            this(plan, (i10 & 2) != 0 ? null : plan2, (i10 & 4) != 0 ? null : th);
        }
    }
}
