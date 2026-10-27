package d5;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import app.shamel.tv.models.AppInfoModel;
import app.shamel.tv.models.WordModels;
import b4.f1;
import java.util.List;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j0 extends b4.f0 {

    /* renamed from: d, reason: collision with root package name */
    public List f4120d;

    /* renamed from: e, reason: collision with root package name */
    public app.shamel.tv.activities.r f4121e;

    /* renamed from: f, reason: collision with root package name */
    public int f4122f;
    public WordModels g;

    @Override // b4.f0
    public final int a() {
        List list = this.f4120d;
        if (list == null) {
            return 0;
        }
        return list.size() + 1;
    }

    @Override // b4.f0
    public final int c(int i10) {
        return i10 == this.f4120d.size() ? 0 : 1;
    }

    @Override // b4.f0
    public final void g(final f1 f1Var, int i10) {
        int i11 = f1Var.f2237f;
        if (i11 == 0) {
            h0 h0Var = (h0) f1Var;
            View view = h0Var.f2232a;
            h0Var.f4111u.setText(this.g.getAdd_playlist());
            final int i12 = 0;
            view.setOnClickListener(new View.OnClickListener(this) { // from class: d5.f0

                /* renamed from: p, reason: collision with root package name */
                public final /* synthetic */ j0 f4098p;

                {
                    this.f4098p = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    switch (i12) {
                        case 0:
                            int b2 = f1Var.b();
                            if (b2 != -1) {
                                this.f4098p.f4121e.c(null, Integer.valueOf(b2), Boolean.TRUE);
                                break;
                            }
                            break;
                        default:
                            int b10 = f1Var.b();
                            if (b10 != -1) {
                                j0 j0Var = this.f4098p;
                                j0Var.f4121e.c((AppInfoModel.UrlModel) j0Var.f4120d.get(b10), Integer.valueOf(b10), Boolean.TRUE);
                                break;
                            }
                            break;
                    }
                }
            });
            view.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: d5.g0

                /* renamed from: p, reason: collision with root package name */
                public final /* synthetic */ j0 f4105p;

                {
                    this.f4105p = this;
                }

                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view2, boolean z10) {
                    switch (i12) {
                        case 0:
                            f1 f1Var2 = f1Var;
                            int b2 = f1Var2.b();
                            View view3 = f1Var2.f2232a;
                            if (b2 != -1) {
                                if (!z10) {
                                    view3.setScaleX(0.9f);
                                    view3.setScaleY(0.9f);
                                    break;
                                } else {
                                    this.f4105p.f4121e.c(null, Integer.valueOf(b2), Boolean.FALSE);
                                    view3.setScaleX(1.0f);
                                    view3.setScaleY(1.0f);
                                    break;
                                }
                            }
                            break;
                        default:
                            f1 f1Var3 = f1Var;
                            int b10 = f1Var3.b();
                            View view4 = f1Var3.f2232a;
                            if (b10 != -1) {
                                if (!z10) {
                                    view4.setScaleX(0.9f);
                                    view4.setScaleY(0.9f);
                                    break;
                                } else {
                                    this.f4105p.f4121e.c(null, Integer.valueOf(b10), Boolean.FALSE);
                                    view4.setScaleX(1.0f);
                                    view4.setScaleY(1.0f);
                                    break;
                                }
                            }
                            break;
                    }
                }
            });
            return;
        }
        if (i11 != 1) {
            return;
        }
        i0 i0Var = (i0) f1Var;
        View view2 = i0Var.f2232a;
        TextView textView = i0Var.f4115u;
        TextView textView2 = i0Var.f4117w;
        if (((AppInfoModel.UrlModel) this.f4120d.get(i10)).getIs_protected().equalsIgnoreCase("1")) {
            textView2.setText("Protected");
        } else {
            textView2.setText(((AppInfoModel.UrlModel) this.f4120d.get(i10)).getUrl());
            if (k5.j.b()) {
                textView2.setVisibility(8);
            }
        }
        i0Var.f4116v.setText(((AppInfoModel.UrlModel) this.f4120d.get(i10)).getName());
        if (this.f4122f == i10) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        final int i13 = 1;
        view2.setOnClickListener(new View.OnClickListener(this) { // from class: d5.f0

            /* renamed from: p, reason: collision with root package name */
            public final /* synthetic */ j0 f4098p;

            {
                this.f4098p = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view22) {
                switch (i13) {
                    case 0:
                        int b2 = f1Var.b();
                        if (b2 != -1) {
                            this.f4098p.f4121e.c(null, Integer.valueOf(b2), Boolean.TRUE);
                            break;
                        }
                        break;
                    default:
                        int b10 = f1Var.b();
                        if (b10 != -1) {
                            j0 j0Var = this.f4098p;
                            j0Var.f4121e.c((AppInfoModel.UrlModel) j0Var.f4120d.get(b10), Integer.valueOf(b10), Boolean.TRUE);
                            break;
                        }
                        break;
                }
            }
        });
        view2.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: d5.g0

            /* renamed from: p, reason: collision with root package name */
            public final /* synthetic */ j0 f4105p;

            {
                this.f4105p = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view22, boolean z10) {
                switch (i13) {
                    case 0:
                        f1 f1Var2 = f1Var;
                        int b2 = f1Var2.b();
                        View view3 = f1Var2.f2232a;
                        if (b2 != -1) {
                            if (!z10) {
                                view3.setScaleX(0.9f);
                                view3.setScaleY(0.9f);
                                break;
                            } else {
                                this.f4105p.f4121e.c(null, Integer.valueOf(b2), Boolean.FALSE);
                                view3.setScaleX(1.0f);
                                view3.setScaleY(1.0f);
                                break;
                            }
                        }
                        break;
                    default:
                        f1 f1Var3 = f1Var;
                        int b10 = f1Var3.b();
                        View view4 = f1Var3.f2232a;
                        if (b10 != -1) {
                            if (!z10) {
                                view4.setScaleX(0.9f);
                                view4.setScaleY(0.9f);
                                break;
                            } else {
                                this.f4105p.f4121e.c(null, Integer.valueOf(b10), Boolean.FALSE);
                                view4.setScaleX(1.0f);
                                view4.setScaleY(1.0f);
                                break;
                            }
                        }
                        break;
                }
            }
        });
    }

    @Override // b4.f0
    public final f1 h(ViewGroup viewGroup, int i10) {
        if (i10 == 0) {
            View h10 = android.support.v4.media.d.h(viewGroup, R.layout.portal_item_add, viewGroup, false);
            h0 h0Var = new h0(h10);
            h0Var.f4111u = (TextView) h10.findViewById(R.id.txt_name);
            return h0Var;
        }
        View h11 = android.support.v4.media.d.h(viewGroup, R.layout.portal_item, viewGroup, false);
        i0 i0Var = new i0(h11);
        i0Var.f4116v = (TextView) h11.findViewById(R.id.txt_name);
        i0Var.f4117w = (TextView) h11.findViewById(R.id.txt_url);
        i0Var.f4115u = (TextView) h11.findViewById(R.id.txt_connected);
        return i0Var;
    }
}
