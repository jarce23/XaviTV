package g7;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    public static final n7.c f5315a;

    /* renamed from: b, reason: collision with root package name */
    public static final n7.c f5316b;

    /* renamed from: c, reason: collision with root package name */
    public static final n7.c f5317c;

    /* renamed from: d, reason: collision with root package name */
    public static final n7.c f5318d;

    /* renamed from: e, reason: collision with root package name */
    public static final n7.c[] f5319e;

    static {
        n7.c cVar = new n7.c("client_side_logging");
        n7.c cVar2 = new n7.c("cxless_client_minimal");
        f5315a = cVar2;
        n7.c cVar3 = new n7.c("cxless_caf_control");
        n7.c cVar4 = new n7.c("module_flag_control");
        f5316b = cVar4;
        n7.c cVar5 = new n7.c("discovery_hint_supply");
        n7.c cVar6 = new n7.c("relay_casting_set_active_account");
        n7.c cVar7 = new n7.c("analytics_proto_enum_translation");
        f5317c = cVar7;
        n7.c cVar8 = new n7.c("integer_to_integer_map");
        f5318d = cVar8;
        f5319e = new n7.c[]{cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7, cVar8, new n7.c("relay_casting_set_remote_casting_mode"), new n7.c("get_relay_access_token"), new n7.c("get_cast_settings"), new n7.c("set_bundle_setting"), new n7.c("get_client_updated_info")};
    }

    public static String a(String str) {
        if (str != null) {
            return x4.r.o(new x4.r(str, 6, (Object) null));
        }
        throw new IllegalArgumentException("applicationId cannot be null");
    }
}
