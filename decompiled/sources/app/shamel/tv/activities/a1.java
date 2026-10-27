package app.shamel.tv.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a1 extends AsyncTask {

    /* renamed from: a, reason: collision with root package name */
    public File f1865a;

    /* renamed from: b, reason: collision with root package name */
    public ProgressDialog f1866b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SettingActivity f1867c;

    public a1(SettingActivity settingActivity) {
        this.f1867c = settingActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x00ad, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x00ae, code lost:
    
        android.util.Log.e("SettingActivity", "doInBackground_002", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x00f8, code lost:
    
        r17 = r9;
        r2.flush();
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x00fd, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0101, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0102, code lost:
    
        android.util.Log.e("SettingActivity", "doInBackground_002", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x00a4, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x00a9, code lost:
    
        r2.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0145 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x013b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0163 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0159 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object doInBackground(java.lang.Object[] r17) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: app.shamel.tv.activities.a1.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        String str = (String) obj;
        this.f1866b.dismiss();
        SettingActivity settingActivity = this.f1867c;
        if (str != null) {
            Toast.makeText(settingActivity.getApplicationContext(), settingActivity.f1859q0.getUpdate_failed(), 0).show();
            return;
        }
        File file = this.f1865a;
        int i10 = SettingActivity.f1845u0;
        Intent intent = new Intent("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT > 24) {
            c0.d c10 = FileProvider.c(settingActivity, "app.shamel.tv.provider");
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry entry = null;
                for (Map.Entry entry2 : c10.f2495b.entrySet()) {
                    String path = ((File) entry2.getValue()).getPath();
                    if (FileProvider.a(canonicalPath).startsWith(FileProvider.a(path) + '/') && (entry == null || path.length() > ((File) entry.getValue()).getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    throw new IllegalArgumentException(r.a.l("Failed to find configured root that contains ", canonicalPath));
                }
                String path2 = ((File) entry.getValue()).getPath();
                intent.setDataAndType(new Uri.Builder().scheme("content").authority(c10.f2494a).encodedPath(Uri.encode((String) entry.getKey()) + '/' + Uri.encode(path2.endsWith("/") ? canonicalPath.substring(path2.length()) : canonicalPath.substring(path2.length() + 1), "/")).build(), "application/vnd.android.package-archive");
                intent.setFlags(268435456);
                intent.addFlags(1);
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        } else {
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            intent.setFlags(268435456);
        }
        settingActivity.startActivity(intent);
    }

    @Override // android.os.AsyncTask
    public final void onPreExecute() {
        SettingActivity settingActivity = this.f1867c;
        ProgressDialog progressDialog = new ProgressDialog(settingActivity);
        this.f1866b = progressDialog;
        progressDialog.setMessage(settingActivity.f1859q0.getRequest_download());
        this.f1866b.setIndeterminate(true);
        this.f1866b.setProgressStyle(1);
        this.f1866b.setCancelable(false);
        this.f1866b.show();
    }

    @Override // android.os.AsyncTask
    public final void onProgressUpdate(Object[] objArr) {
        this.f1866b.setIndeterminate(false);
        this.f1866b.setMax(100);
        this.f1866b.setProgress(((Integer[]) objArr)[0].intValue());
    }
}
