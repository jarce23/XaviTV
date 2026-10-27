package f;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public final b f4778a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4779b;

    public f(Context context) {
        this(context, g.g(context, 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.widget.ListAdapter] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    public g create() {
        b bVar = this.f4778a;
        g gVar = new g(bVar.f4701a, this.f4779b);
        View view = bVar.f4705e;
        e eVar = gVar.f4787t;
        if (view != null) {
            eVar.f4770w = view;
        } else {
            CharSequence charSequence = bVar.f4704d;
            if (charSequence != null) {
                eVar.f4752d = charSequence;
                TextView textView = eVar.f4768u;
                if (textView != null) {
                    textView.setText(charSequence);
                }
            }
            Drawable drawable = bVar.f4703c;
            if (drawable != null) {
                eVar.f4766s = drawable;
                ImageView imageView = eVar.f4767t;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    eVar.f4767t.setImageDrawable(drawable);
                }
            }
        }
        String str = bVar.f4706f;
        if (str != null) {
            eVar.f4753e = str;
            TextView textView2 = eVar.f4769v;
            if (textView2 != null) {
                textView2.setText(str);
            }
        }
        CharSequence charSequence2 = bVar.g;
        if (charSequence2 != null) {
            eVar.c(-1, charSequence2, bVar.f4707h);
        }
        CharSequence charSequence3 = bVar.f4708i;
        if (charSequence3 != null) {
            eVar.c(-2, charSequence3, bVar.f4709j);
        }
        if (bVar.f4712m != null) {
            AlertController$RecycleListView alertController$RecycleListView = (AlertController$RecycleListView) bVar.f4702b.inflate(eVar.A, (ViewGroup) null);
            int i10 = bVar.f4715p ? eVar.B : eVar.C;
            Object obj = bVar.f4712m;
            ?? r82 = obj;
            if (obj == null) {
                r82 = new d(bVar.f4701a, i10, R.id.text1, null);
            }
            eVar.f4771x = r82;
            eVar.f4772y = bVar.f4716q;
            if (bVar.f4713n != null) {
                alertController$RecycleListView.setOnItemClickListener(new a(bVar, eVar));
            }
            if (bVar.f4715p) {
                alertController$RecycleListView.setChoiceMode(1);
            }
            eVar.f4754f = alertController$RecycleListView;
        }
        View view2 = bVar.f4714o;
        if (view2 != null) {
            eVar.g = view2;
            eVar.f4755h = false;
        }
        gVar.setCancelable(bVar.f4710k);
        if (bVar.f4710k) {
            gVar.setCanceledOnTouchOutside(true);
        }
        gVar.setOnCancelListener(null);
        gVar.setOnDismissListener(null);
        l.m mVar = bVar.f4711l;
        if (mVar != null) {
            gVar.setOnKeyListener(mVar);
        }
        return gVar;
    }

    public Context getContext() {
        return this.f4778a.f4701a;
    }

    public f setNegativeButton(int i10, DialogInterface.OnClickListener onClickListener) {
        b bVar = this.f4778a;
        bVar.f4708i = bVar.f4701a.getText(i10);
        bVar.f4709j = onClickListener;
        return this;
    }

    public f setPositiveButton(int i10, DialogInterface.OnClickListener onClickListener) {
        b bVar = this.f4778a;
        bVar.g = bVar.f4701a.getText(i10);
        bVar.f4707h = onClickListener;
        return this;
    }

    public f setTitle(CharSequence charSequence) {
        this.f4778a.f4704d = charSequence;
        return this;
    }

    public f setView(View view) {
        this.f4778a.f4714o = view;
        return this;
    }

    public f(Context context, int i10) {
        this.f4778a = new b(new ContextThemeWrapper(context, g.g(context, i10)));
        this.f4779b = i10;
    }
}
