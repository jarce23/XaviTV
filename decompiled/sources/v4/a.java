package v4;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import o4.p;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends d {
    public final /* synthetic */ int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Context context, x4.i iVar, int i10) {
        super(context, iVar);
        this.g = i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0036, code lost:
    
        if (r0.equals("android.intent.action.DEVICE_STORAGE_OK") == false) goto L20;
     */
    @Override // v4.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a() {
        /*
            r5 = this;
            int r0 = r5.g
            switch(r0) {
                case 0: goto L8a;
                case 1: goto L45;
                default: goto L5;
            }
        L5:
            r0 = 0
            android.content.IntentFilter r1 = r5.e()
            android.content.Context r2 = r5.f12668b
            android.content.Intent r0 = r2.registerReceiver(r0, r1)
            r1 = 1
            if (r0 == 0) goto L40
            java.lang.String r2 = r0.getAction()
            if (r2 != 0) goto L1a
            goto L40
        L1a:
            java.lang.String r0 = r0.getAction()
            r2 = 0
            if (r0 == 0) goto L3f
            int r3 = r0.hashCode()
            r4 = -1181163412(0xffffffffb998e06c, float:-2.9158907E-4)
            if (r3 == r4) goto L39
            r4 = -730838620(0xffffffffd47049a4, float:-4.12811054E12)
            if (r3 == r4) goto L30
            goto L3f
        L30:
            java.lang.String r3 = "android.intent.action.DEVICE_STORAGE_OK"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L40
            goto L3f
        L39:
            java.lang.String r1 = "android.intent.action.DEVICE_STORAGE_LOW"
            boolean r0 = r0.equals(r1)
        L3f:
            r1 = r2
        L40:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            return r0
        L45:
            android.content.IntentFilter r0 = new android.content.IntentFilter
            java.lang.String r1 = "android.intent.action.BATTERY_CHANGED"
            r0.<init>(r1)
            android.content.Context r1 = r5.f12668b
            r2 = 0
            android.content.Intent r0 = r1.registerReceiver(r2, r0)
            if (r0 != 0) goto L63
            o4.p r0 = o4.p.d()
            java.lang.String r1 = v4.c.f12664a
            java.lang.String r2 = "getInitialState - null intent received"
            r0.b(r1, r2)
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            goto L89
        L63:
            java.lang.String r1 = "status"
            r2 = -1
            int r1 = r0.getIntExtra(r1, r2)
            java.lang.String r3 = "level"
            int r3 = r0.getIntExtra(r3, r2)
            java.lang.String r4 = "scale"
            int r0 = r0.getIntExtra(r4, r2)
            float r2 = (float) r3
            float r0 = (float) r0
            float r2 = r2 / r0
            r0 = 1
            if (r1 == r0) goto L85
            r1 = 1041865114(0x3e19999a, float:0.15)
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 <= 0) goto L84
            goto L85
        L84:
            r0 = 0
        L85:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
        L89:
            return r0
        L8a:
            android.content.IntentFilter r0 = new android.content.IntentFilter
            java.lang.String r1 = "android.intent.action.BATTERY_CHANGED"
            r0.<init>(r1)
            android.content.Context r1 = r5.f12668b
            r2 = 0
            android.content.Intent r0 = r1.registerReceiver(r2, r0)
            if (r0 != 0) goto La8
            o4.p r0 = o4.p.d()
            java.lang.String r1 = v4.b.f12663a
            java.lang.String r2 = "getInitialState - null intent received"
            r0.b(r1, r2)
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            goto Lbd
        La8:
            java.lang.String r1 = "status"
            r2 = -1
            int r0 = r0.getIntExtra(r1, r2)
            r1 = 2
            if (r0 == r1) goto Lb8
            r1 = 5
            if (r0 != r1) goto Lb6
            goto Lb8
        Lb6:
            r0 = 0
            goto Lb9
        Lb8:
            r0 = 1
        Lb9:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
        Lbd:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.a.a():java.lang.Object");
    }

    @Override // v4.d
    public final IntentFilter e() {
        switch (this.g) {
            case 0:
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.CHARGING");
                intentFilter.addAction("android.os.action.DISCHARGING");
                return intentFilter;
            case 1:
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.BATTERY_OKAY");
                intentFilter2.addAction("android.intent.action.BATTERY_LOW");
                return intentFilter2;
            default:
                IntentFilter intentFilter3 = new IntentFilter();
                intentFilter3.addAction("android.intent.action.DEVICE_STORAGE_OK");
                intentFilter3.addAction("android.intent.action.DEVICE_STORAGE_LOW");
                return intentFilter3;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @Override // v4.d
    public final void f(Intent intent) {
        switch (this.g) {
            case 0:
                String action = intent.getAction();
                if (action != null) {
                    p.d().a(b.f12663a, "Received ".concat(action));
                    switch (action.hashCode()) {
                        case -1886648615:
                            if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                                b(Boolean.FALSE);
                                break;
                            }
                            break;
                        case -54942926:
                            if (action.equals("android.os.action.DISCHARGING")) {
                                b(Boolean.FALSE);
                                break;
                            }
                            break;
                        case 948344062:
                            if (action.equals("android.os.action.CHARGING")) {
                                b(Boolean.TRUE);
                                break;
                            }
                            break;
                        case 1019184907:
                            if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                                b(Boolean.TRUE);
                                break;
                            }
                            break;
                    }
                }
                break;
            case 1:
                if (intent.getAction() != null) {
                    p.d().a(c.f12664a, "Received " + intent.getAction());
                    String action2 = intent.getAction();
                    if (action2 != null) {
                        int hashCode = action2.hashCode();
                        if (hashCode == -1980154005) {
                            if (action2.equals("android.intent.action.BATTERY_OKAY")) {
                                b(Boolean.TRUE);
                                break;
                            }
                        } else if (hashCode == 490310653 && action2.equals("android.intent.action.BATTERY_LOW")) {
                            b(Boolean.FALSE);
                            break;
                        }
                    }
                }
                break;
            default:
                if (intent.getAction() != null) {
                    p.d().a(k.f12675a, "Received " + intent.getAction());
                    String action3 = intent.getAction();
                    if (action3 != null) {
                        int hashCode2 = action3.hashCode();
                        if (hashCode2 == -1181163412) {
                            if (action3.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
                                b(Boolean.FALSE);
                                break;
                            }
                        } else if (hashCode2 == -730838620 && action3.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                            b(Boolean.TRUE);
                            break;
                        }
                    }
                }
                break;
        }
    }
}
