package com.puravidaapps;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.ReplForm;
import com.google.appinventor.components.runtime.util.AsynchUtil;
import com.google.appinventor.components.runtime.util.MediaUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class TaifunImage extends AndroidNonvisibleComponent implements Component {
    public static final int a = 4;
    private static final String e = "TaifunImage";
    private ComponentContainer b;
    private Context c;
    private final Activity d;
    private boolean f = false;
    private boolean g;

    public class ScalingUtilities {
        public ScalingUtilities() {
        }

        public int a(int i, int i2, int i3, int i4, String str) {
            return str.equals("FIT") ? ((float) i) / ((float) i2) > ((float) i3) / ((float) i4) ? i / i3 : i2 / i4 : ((float) i) / ((float) i2) > ((float) i3) / ((float) i4) ? i2 / i4 : i / i3;
        }

        public Bitmap a(Bitmap bitmap, int i, int i2, String str) {
            Rect b = b(bitmap.getWidth(), bitmap.getHeight(), i, i2, str);
            Rect c = c(bitmap.getWidth(), bitmap.getHeight(), i, i2, str);
            Bitmap createBitmap = Bitmap.createBitmap(c.width(), c.height(), Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawBitmap(bitmap, b, c, new Paint(2));
            return createBitmap;
        }

        public Bitmap a(String str, int i, int i2, String str2) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(options.outWidth, options.outHeight, i, i2, str2);
            return BitmapFactory.decodeFile(str, options);
        }

        public Rect b(int i, int i2, int i3, int i4, String str) {
            if (!str.equals("CROP")) {
                return new Rect(0, 0, i, i2);
            }
            float f = ((float) i3) / ((float) i4);
            if (((float) i) / ((float) i2) > f) {
                int i5 = (int) (((float) i2) * f);
                int i6 = (i - i5) / 2;
                return new Rect(i6, 0, i5 + i6, i2);
            }
            int i7 = (int) (((float) i) / f);
            int i8 = (i2 - i7) / 2;
            return new Rect(0, i8, i, i7 + i8);
        }

        public Rect c(int i, int i2, int i3, int i4, String str) {
            if (!str.equals("FIT")) {
                return new Rect(0, 0, i3, i4);
            }
            float f = ((float) i) / ((float) i2);
            return f > ((float) i3) / ((float) i4) ? new Rect(0, 0, i3, (int) (((float) i3) / f)) : new Rect(0, 0, (int) (f * ((float) i4)), i4);
        }
    }

    public TaifunImage(ComponentContainer componentContainer) {
        super(componentContainer.$form());
        this.b = componentContainer;
        this.c = componentContainer.$context();
        this.d = componentContainer.$context();
        Log.d(e, "TaifunImage Created");
        if (this.form instanceof ReplForm) {
            this.f = true;
        }
    }

    /* access modifiers changed from: private */
    public void AfterEncoding(String str) {
        Log.d(e, "AfterEncoding");
        EventDispatcher.dispatchEvent(this, "AfterEncoding", str);
    }

    private String Decode(String str) {
        byte[] decode = Base64.decode(str, 0);
        return a(BitmapFactory.decodeByteArray(decode, 0, decode.length));
    }

    private void Encode(final String str) {
        AsynchUtil.runAsynchronously(new Runnable() {
            public void run() {
                TaifunImage.this.g(str);
            }
        });
    }

    private String a(Bitmap bitmap) {
        File file = new File((Environment.getExternalStorageDirectory().getPath() + "/Pictures/") + "/decodedImages");
        file.mkdirs();
        String str = "Image-" + System.currentTimeMillis() + ".jpg";
        File file2 = new File(file, str);
        if (file2.exists()) {
            file2.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return file.toString() + File.separator + str;
        } catch (Exception e2) {
            Log.e(e, e2.getMessage(), e2);
            e2.printStackTrace();
            if (!this.g) {
                Toast.makeText(this.c, e2.getMessage(), 0).show();
            }
            return "";
        }
    }

    private String a(String str) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (str.startsWith("file:///")) {
            str = str.substring(7);
        } else if (str.startsWith("//")) {
            str = str.substring(2);
            if (this.f) {
                str = Environment.getExternalStorageDirectory().getPath() + "/AppInventor/assets/" + str;
            }
        } else if (!str.startsWith("/")) {
            str = externalStorageDirectory + File.separator + str;
        } else if (!str.startsWith(externalStorageDirectory.toString())) {
            str = externalStorageDirectory + str;
        }
        Log.d(e, "completeFileName= " + str);
        return str;
    }

    /* access modifiers changed from: private */
    public void a(final String str, int i) {
        Log.d(e, "AsyncRotate");
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(str, new BitmapFactory.Options());
            Matrix matrix = new Matrix();
            matrix.postRotate((float) i);
            Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true).compress(Bitmap.CompressFormat.JPEG, 80, new FileOutputStream(str));
            this.d.runOnUiThread(new Runnable() {
                public void run() {
                    TaifunImage.this.Rotated(true, str);
                }
            });
        } catch (Exception e2) {
            Log.e(e, e2.getMessage(), e2);
            this.d.runOnUiThread(new Runnable() {
                public void run() {
                    TaifunImage.this.Rotated(false, e2.getMessage());
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, int i, int i2) {
        Log.d(e, "AsyncCreateChunks");
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(new FileInputStream(str));
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, decodeStream.getWidth(), decodeStream.getHeight(), true);
            int height = decodeStream.getHeight() / i;
            int width = decodeStream.getWidth() / i2;
            Log.d(e, "AsyncCreateChunks, rows: " + i + ", columns: " + i2 + ", chunkHeight: " + height + ", chunkWidth: " + width);
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                int i6 = i3;
                if (i5 < i) {
                    int i7 = 0;
                    int i8 = 0;
                    while (true) {
                        int i9 = i7;
                        if (i9 >= i2) {
                            break;
                        }
                        Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap, i8, i6, width, height);
                        try {
                            String str2 = c(str) + "_" + (i5 + 1) + "_" + (i9 + 1) + "." + b(str);
                            FileOutputStream fileOutputStream = new FileOutputStream(str2);
                            createBitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                            arrayList.add(str2);
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (Exception e2) {
                            Log.e(e, e2.getMessage(), e2);
                            a(false, (Object) e2.getMessage());
                        }
                        i8 += width;
                        i7 = i9 + 1;
                    }
                    i3 = i6 + height;
                    i4 = i5 + 1;
                } else {
                    a(true, (Object) arrayList);
                    return;
                }
            }
        } catch (FileNotFoundException e3) {
            Log.e(e, e3.getMessage(), e3);
            e3.printStackTrace();
            a(false, (Object) e3.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void a(final String str, int i, int i2, String str2) {
        Log.d(e, "AsyncScale");
        ScalingUtilities scalingUtilities = new ScalingUtilities();
        Bitmap a2 = scalingUtilities.a(scalingUtilities.a(str, i, i2, str2), i, i2, str2);
        try {
            a2.compress(Bitmap.CompressFormat.JPEG, 80, new FileOutputStream(str));
            this.d.runOnUiThread(new Runnable() {
                public void run() {
                    TaifunImage.this.Scaled(true, str);
                }
            });
        } catch (Exception e2) {
            Log.e(e, e2.getMessage(), e2);
            this.d.runOnUiThread(new Runnable() {
                public void run() {
                    TaifunImage.this.Scaled(false, str);
                }
            });
        }
    }

    private void a(final boolean z, final Object obj) {
        this.d.runOnUiThread(new Runnable() {
            public void run() {
                TaifunImage.this.ChunksCreated(z, obj);
            }
        });
    }

    private static String b(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf == str.length() + -1) ? "" : str.substring(lastIndexOf + 1, str.length());
    }

    private static String c(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? str : lastIndexOf == 0 ? "" : str.substring(0, lastIndexOf);
    }

    private boolean d(String str) {
        return b(str).equalsIgnoreCase("jpg") || b(str).equalsIgnoreCase("jpeg");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0057 A[SYNTHETIC, Splitter:B:23:0x0057] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap e(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 0
            java.lang.String r1 = "TaifunImage"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getBitmapFromAsset: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r6)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r1, r2)
            android.content.Context r1 = r5.c
            android.content.res.AssetManager r1 = r1.getAssets()
            java.io.InputStream r2 = r1.open(r6)     // Catch:{ IOException -> 0x002d, all -> 0x0052 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch:{ IOException -> 0x0061 }
            if (r2 == 0) goto L_0x002c
            r2.close()     // Catch:{ IOException -> 0x005b }
        L_0x002c:
            return r0
        L_0x002d:
            r1 = move-exception
            r2 = r0
        L_0x002f:
            java.lang.String r3 = "TaifunImage"
            java.lang.String r4 = r1.getMessage()     // Catch:{ all -> 0x005f }
            android.util.Log.e(r3, r4)     // Catch:{ all -> 0x005f }
            boolean r3 = r5.g     // Catch:{ all -> 0x005f }
            if (r3 != 0) goto L_0x004a
            android.content.Context r3 = r5.c     // Catch:{ all -> 0x005f }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x005f }
            r4 = 0
            android.widget.Toast r1 = android.widget.Toast.makeText(r3, r1, r4)     // Catch:{ all -> 0x005f }
            r1.show()     // Catch:{ all -> 0x005f }
        L_0x004a:
            if (r2 == 0) goto L_0x002c
            r2.close()     // Catch:{ IOException -> 0x0050 }
            goto L_0x002c
        L_0x0050:
            r1 = move-exception
            goto L_0x002c
        L_0x0052:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x0055:
            if (r2 == 0) goto L_0x005a
            r2.close()     // Catch:{ IOException -> 0x005d }
        L_0x005a:
            throw r0
        L_0x005b:
            r1 = move-exception
            goto L_0x002c
        L_0x005d:
            r1 = move-exception
            goto L_0x005a
        L_0x005f:
            r0 = move-exception
            goto L_0x0055
        L_0x0061:
            r1 = move-exception
            goto L_0x002f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.puravidaapps.TaifunImage.e(java.lang.String):android.graphics.Bitmap");
    }

    private static byte[] f(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    /* access modifiers changed from: private */
    public void g(String str) {
        BitmapDrawable bitmapDrawable;
        if (str == null) {
            str = "";
        }
        try {
            bitmapDrawable = MediaUtil.getBitmapDrawable(this.b.$form(), str);
        } catch (IOException e2) {
            Log.e(e, "Unable to load " + str);
            bitmapDrawable = null;
        }
        Bitmap bitmap = bitmapDrawable.getBitmap();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        final String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        this.d.runOnUiThread(new Runnable() {
            public void run() {
                TaifunImage.this.AfterEncoding(encodeToString);
            }
        });
    }

    public void ChunksCreated(boolean z, Object obj) {
        Log.d(e, "ChunksCreated: " + z + ", message: " + obj);
        EventDispatcher.dispatchEvent(this, "ChunksCreated", Boolean.valueOf(z), obj);
    }

    public void CreateChunks(String str, final int i, final int i2) {
        final String a2 = a(str);
        Log.d(e, "CreateChunks, completeFileName: " + a2);
        File file = new File(a2);
        if (str.startsWith("//")) {
            Log.d(e, "CreateChunks: sorry, can't create chunks of a file in the assets.");
            ChunksCreated(false, "Sorry, can't create chunks of a file in the assets.");
        } else if (file.isDirectory()) {
            Log.d(e, "CreateChunks: Sorry, can't create chunks of a directory.");
            ChunksCreated(false, "Sorry, can't create chunks of a directory.");
        } else if (!file.exists()) {
            Log.d(e, "CreateChunks: Sorry, image file does not exist.");
            ChunksCreated(false, "Sorry, image file does not exist.");
        } else if (!d(str)) {
            Log.d(e, "CreateChunks: Sorry, image file must be in jpg format.");
            ChunksCreated(false, "Sorry, image file must be in jpg format.");
        } else if (i * i2 > 1000) {
            Log.d(e, "CreateChunks: Sorry, too much chunks, reduze rows and/or columns.");
            ChunksCreated(false, "Sorry, too much chunks, reduze rows and/or columns!");
        } else {
            AsynchUtil.runAsynchronously(new Runnable() {
                public void run() {
                    TaifunImage.this.a(a2, i, i2);
                }
            });
        }
    }

    public void Crop(String str, int i, int i2, int i3, int i4) {
        String a2 = a(str);
        Log.d(e, "Crop, completeFileName: " + a2);
        File file = new File(a2);
        if (str.startsWith("//")) {
            Log.d(e, "Crop: sorry, can't crop a file in the assets.");
            if (!this.g) {
                Toast.makeText(this.c, "Sorry, can't crop a file in the assets.", 0).show();
            }
        } else if (file.isDirectory()) {
            Log.d(e, "Crop: Sorry, can't crop a directory.");
            if (!this.g) {
                Toast.makeText(this.c, "Sorry, can't crop a directory.", 0).show();
            }
        } else if (!file.exists()) {
            Log.d(e, "Crop: Sorry, file to crop does not exist.");
            if (!this.g) {
                Toast.makeText(this.c, "Sorry, file to crop does not exist.", 0).show();
            }
        } else if (!d(str)) {
            Log.d(e, "Crop: Sorry, file to crop must be in jpg format.");
            if (!this.g) {
                Toast.makeText(this.c, "Sorry, file to crop must be in jpg format.", 0).show();
            }
        } else {
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(a2, new BitmapFactory.Options());
                int width = (decodeFile.getWidth() - i) - i3;
                int height = (decodeFile.getHeight() - i2) - i4;
                if (width < 0) {
                    Log.d(e, "Crop: width of cropped image must be > 0.");
                    if (!this.g) {
                        Toast.makeText(this.c, "Width of cropped image must be > 0.", 0).show();
                    }
                } else if (height < 0) {
                    Log.d(e, "Crop: height of cropped image must be > 0.");
                    if (!this.g) {
                        Toast.makeText(this.c, "Height of cropped image must be > 0.", 0).show();
                    }
                } else {
                    Log.d(e, "Crop: " + i + ", " + i2 + ", " + width + ", " + height);
                    Bitmap.createBitmap(decodeFile, i, i2, width, height).compress(Bitmap.CompressFormat.JPEG, 80, new FileOutputStream(a2));
                }
            } catch (Exception e2) {
                Log.e(e, e2.getMessage(), e2);
                if (!this.g) {
                    Toast.makeText(this.c, e2.getMessage(), 0).show();
                }
            }
        }
    }

    public int Height(String str) {
        return BitmapFactory.decodeFile(a(str), (BitmapFactory.Options) null).getHeight();
    }

    public String HexStringToImage(String str, String str2) {
        String a2 = a("/Pictures/image.jpg");
        byte[] f2 = f(str);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(f2, 0, f2.length);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(a2);
            if (str2.equals("PNG")) {
                decodeByteArray.compress(Bitmap.CompressFormat.PNG, 80, fileOutputStream);
            } else {
                decodeByteArray.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
            }
        } catch (Exception e2) {
            Log.e(e, e2.getMessage(), e2);
            if (!this.g) {
                Toast.makeText(this.c, e2.getMessage(), 0).show();
            }
        }
        return a2;
    }

    public boolean IsLandscape(String str) {
        Bitmap decodeFile = BitmapFactory.decodeFile(a(str), (BitmapFactory.Options) null);
        return decodeFile.getWidth() > decodeFile.getHeight();
    }

    public String Overlay(String str, String str2) {
        Bitmap decodeFile;
        String a2 = a(str);
        String a3 = a(str2);
        Log.d(e, "Overlay");
        File file = new File(a2);
        if (str.startsWith("//")) {
            Log.d(e, "Overlay: sorry, can't overlay a file in the assets.");
            if (!this.g) {
                Toast.makeText(this.c, "Overlay: sorry, can't overlay a file in the assets.", 0).show();
            }
            return "";
        } else if (file.isDirectory()) {
            Log.d(e, "Overlay: Sorry, imageFileName1 is not a filename.");
            if (!this.g) {
                Toast.makeText(this.c, "Overlay: Sorry, imageFileName1 is not a filename.", 0).show();
            }
            return "";
        } else if (!file.exists()) {
            Log.d(e, "Overlay: Sorry, imageFileName1 does not exist.");
            if (!this.g) {
                Toast.makeText(this.c, "Overlay: Sorry, imageFileName1 does not exist.", 0).show();
            }
            return "";
        } else {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                Bitmap decodeFile2 = BitmapFactory.decodeFile(a2, options);
                if (!str2.startsWith("//") || this.f) {
                    decodeFile = BitmapFactory.decodeFile(a3, options);
                } else {
                    decodeFile = e(str2.substring(2));
                }
                if (decodeFile == null) {
                    Log.d(e, "Overlay: Sorry, imageFileName2 does not exist.");
                    if (!this.g) {
                        Toast.makeText(this.c, "Overlay: Sorry, imageFileName2 does not exist.", 0).show();
                    }
                    return "";
                }
                try {
                    int width = decodeFile2.getWidth();
                    int height = decodeFile2.getHeight();
                    int width2 = decodeFile.getWidth();
                    Bitmap createBitmap = Bitmap.createBitmap(width, height, decodeFile2.getConfig());
                    Canvas canvas = new Canvas(createBitmap);
                    canvas.drawBitmap(decodeFile2, new Matrix(), (Paint) null);
                    canvas.drawBitmap(decodeFile, (float) ((((double) width) * 0.5d) - (((double) width2) * 0.5d)), (float) ((((double) height) * 0.5d) - (((double) decodeFile.getHeight()) * 0.5d)), (Paint) null);
                    createBitmap.compress(Bitmap.CompressFormat.JPEG, 80, new FileOutputStream(a2));
                    return a2;
                } catch (Exception e2) {
                    Log.e(e, e2.getMessage());
                    if (!this.g) {
                        Toast.makeText(this.c, e2.getMessage(), 0).show();
                    }
                    return "";
                }
            } catch (Exception e3) {
                Log.e(e, e3.getMessage());
                if (!this.g) {
                    Toast.makeText(this.c, e3.getMessage(), 0).show();
                }
                return "";
            }
        }
    }

    public void Resize(String str, int i, int i2) {
        String a2 = a(str);
        Log.d(e, "Resize, completeFileName: " + a2);
        File file = new File(a2);
        if (str.startsWith("//")) {
            Log.d(e, "Resize: sorry, can't resize a file in the assets.");
            if (!this.g) {
                Toast.makeText(this.c, "Sorry, can't resize a file in the assets.", 0).show();
            }
        } else if (file.isDirectory()) {
            Log.d(e, "Resize: Sorry, can't resize a directory.");
            if (!this.g) {
                Toast.makeText(this.c, "Sorry, can't resize a directory.", 0).show();
            }
        } else if (!file.exists()) {
            Log.d(e, "Resize: Sorry, file to resize does not exist.");
            if (!this.g) {
                Toast.makeText(this.c, "Sorry, file to resize does not exist.", 0).show();
            }
        } else if (!d(str)) {
            Log.d(e, "Crop: Sorry, file to resize must be in jpg format.");
            if (!this.g) {
                Toast.makeText(this.c, "Sorry, file to resize must be in jpg format.", 0).show();
            }
        } else {
            try {
                FileInputStream fileInputStream = new FileInputStream(a2);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(fileInputStream, (Rect) null, options);
                fileInputStream.close();
                int i3 = options.outWidth;
                int i4 = options.outHeight;
                FileInputStream fileInputStream2 = new FileInputStream(a2);
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inSampleSize = Math.max(i3 / i, i4 / i2);
                Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream2, (Rect) null, options2);
                Matrix matrix = new Matrix();
                matrix.setRectToRect(new RectF(0.0f, 0.0f, (float) decodeStream.getWidth(), (float) decodeStream.getHeight()), new RectF(0.0f, 0.0f, (float) i, (float) i2), Matrix.ScaleToFit.CENTER);
                float[] fArr = new float[9];
                matrix.getValues(fArr);
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, (int) (((float) decodeStream.getWidth()) * fArr[0]), (int) (fArr[4] * ((float) decodeStream.getHeight())), true);
                try {
                    createScaledBitmap.compress(Bitmap.CompressFormat.JPEG, 80, new FileOutputStream(a2));
                } catch (Exception e2) {
                    Log.e(e, e2.getMessage(), e2);
                    if (!this.g) {
                        Toast.makeText(this.c, e2.getMessage(), 0).show();
                    }
                }
            } catch (IOException e3) {
                Log.e(e, e3.getMessage(), e3);
                if (!this.g) {
                    Toast.makeText(this.c, e3.getMessage(), 0).show();
                }
            }
        }
    }

    public void Rotate(String str, final int i) {
        final String a2 = a(str);
        Log.d(e, "Rotate, completeFileName: " + a2);
        File file = new File(a2);
        if (str.startsWith("//")) {
            Log.d(e, "Rotate: sorry, can't rotate a file in the assets.");
            Rotated(false, "Sorry, can't rotate a file in the assets.");
        } else if (file.isDirectory()) {
            Log.d(e, "Rotate: Sorry, imageFileName is not a filename.");
            Rotated(false, "Sorry, imageFileName is not a filename.");
        } else if (!file.exists()) {
            Log.d(e, "Rotate: Sorry, file to rotate does not exist.");
            Rotated(false, "Sorry, file to rotate does not exist.");
        } else if (!d(str)) {
            Log.d(e, "Rotate: Sorry, file to rotate must be in jpg format.");
            Rotated(false, "Sorry, file to rotate must be in jpg format.");
        } else if (i != 0 && i != 90 && i != 180 && i != 270) {
            Log.d(e, "Rotate: Sorry, angle must be 0, 90, 180 or 270.");
            Rotated(false, "Sorry, angle must be 0, 90, 180 or 270.");
        } else if (i == 0) {
            Rotated(true, a2);
        } else {
            AsynchUtil.runAsynchronously(new Runnable() {
                public void run() {
                    TaifunImage.this.a(a2, i);
                }
            });
        }
    }

    public void Rotated(boolean z, String str) {
        Log.d(e, "Rotated: " + z + ", message: " + str);
        EventDispatcher.dispatchEvent(this, "Rotated", Boolean.valueOf(z), str);
    }

    public void Scale(String str, int i, int i2, String str2) {
        final String a2 = a(str);
        Log.d(e, "Scale, completeFileName: " + a2);
        File file = new File(a2);
        if (str.startsWith("//")) {
            Log.d(e, "Scale: sorry, can't scale a file in the assets.");
            Scaled(false, "Sorry, can't scale a file in the assets.");
        } else if (file.isDirectory()) {
            Log.d(e, "Scale: Sorry, can't scale a directory.");
            Scaled(false, "Scale: Sorry, can't scale a directory.");
        } else if (!file.exists()) {
            Log.d(e, "Scale: Sorry, file to scale does not exist.");
            Scaled(false, "Scale: Sorry, file to scale does not exist.");
        } else if (!d(str)) {
            Log.d(e, "Scale: Sorry, file to scale must be in jpg format.");
            Scaled(false, "Scale: Sorry, file to scale must be in jpg format.");
        } else if (str2.equals("CROP") || str2.equals("FIT")) {
            final int i3 = i;
            final int i4 = i2;
            final String str3 = str2;
            AsynchUtil.runAsynchronously(new Runnable() {
                public void run() {
                    TaifunImage.this.a(a2, i3, i4, str3);
                }
            });
        } else {
            Log.d(e, "Scale: Sorry, scalingLogic must be CROP or FIT.");
            Scaled(false, "Scale: Sorry, scalingLogic must be CROP or FIT.");
        }
    }

    public void Scaled(boolean z, String str) {
        Log.d(e, "Scaled: " + z + ", message: " + str);
        EventDispatcher.dispatchEvent(this, "Scaled", Boolean.valueOf(z), str);
    }

    public void SuppressWarnings(boolean z) {
        this.g = z;
    }

    public boolean SuppressWarnings() {
        return this.g;
    }

    public int Width(String str) {
        return BitmapFactory.decodeFile(a(str), (BitmapFactory.Options) null).getWidth();
    }
}
