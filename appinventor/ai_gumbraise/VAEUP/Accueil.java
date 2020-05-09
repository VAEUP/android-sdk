package appinventor.ai_gumbraise.VAEUP;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import cn.colintree.aix.SwipeRefresh.SwipeRefresh;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.AppInventorCompatActivity;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.Image;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.VerticalArrangement;
import com.google.appinventor.components.runtime.VerticalScrollArrangement;
import com.google.appinventor.components.runtime.WebViewer;
import com.google.appinventor.components.runtime.errors.PermissionException;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.RetValManager;
import com.google.appinventor.components.runtime.util.RuntimeErrorAlert;
import com.google.youngandroid.runtime;
import com.puravidaapps.TaifunImage;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.Format;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.functions.IsEqual;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.reflect.SlotSet;
import gnu.lists.Consumer;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.lists.VoidConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.lang.Promise;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.strings;
import kawa.standard.Scheme;
import kawa.standard.require;

/* compiled from: Accueil.yail */
public class Accueil extends Form implements Runnable {
    public static Accueil Accueil;
    static final SimpleSymbol Lit0 = ((SimpleSymbol) new SimpleSymbol("Accueil").readResolve());
    static final SimpleSymbol Lit1 = ((SimpleSymbol) new SimpleSymbol("getMessage").readResolve());
    static final SimpleSymbol Lit10 = ((SimpleSymbol) new SimpleSymbol("BackgroundColor").readResolve());
    static final SimpleSymbol Lit100 = ((SimpleSymbol) new SimpleSymbol("Label3").readResolve());
    static final IntNum Lit101 = IntNum.make(14);
    static final FString Lit102 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit103 = new FString("com.google.appinventor.components.runtime.WebViewer");
    static final SimpleSymbol Lit104 = ((SimpleSymbol) new SimpleSymbol("WebViewer1").readResolve());
    static final SimpleSymbol Lit105 = ((SimpleSymbol) new SimpleSymbol("HomeUrl").readResolve());
    static final FString Lit106 = new FString("com.google.appinventor.components.runtime.WebViewer");
    static final SimpleSymbol Lit107 = ((SimpleSymbol) new SimpleSymbol("WebViewer1$ErrorOccurred").readResolve());
    static final SimpleSymbol Lit108 = ((SimpleSymbol) new SimpleSymbol("ErrorOccurred").readResolve());
    static final SimpleSymbol Lit109 = ((SimpleSymbol) new SimpleSymbol("CancelRefreshing").readResolve());
    static final IntNum Lit11;
    static final SimpleSymbol Lit110 = ((SimpleSymbol) new SimpleSymbol("WebViewer1$PageLoaded").readResolve());
    static final SimpleSymbol Lit111 = ((SimpleSymbol) new SimpleSymbol("PageLoaded").readResolve());
    static final FString Lit112 = new FString("com.google.appinventor.components.runtime.VerticalScrollArrangement");
    static final SimpleSymbol Lit113 = ((SimpleSymbol) new SimpleSymbol("VerticalScrollArrangement2").readResolve());
    static final FString Lit114 = new FString("com.google.appinventor.components.runtime.VerticalScrollArrangement");
    static final FString Lit115 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final SimpleSymbol Lit116 = ((SimpleSymbol) new SimpleSymbol("VerticalArrangement6").readResolve());
    static final IntNum Lit117;
    static final FString Lit118 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final FString Lit119 = new FString("com.puravidaapps.TaifunImage");
    static final SimpleSymbol Lit12 = ((SimpleSymbol) new SimpleSymbol("CloseScreenAnimation").readResolve());
    static final SimpleSymbol Lit120 = ((SimpleSymbol) new SimpleSymbol("TaifunImage1").readResolve());
    static final FString Lit121 = new FString("com.puravidaapps.TaifunImage");
    static final FString Lit122 = new FString("cn.colintree.aix.SwipeRefresh.SwipeRefresh");
    static final IntNum Lit123;
    static final FString Lit124 = new FString("cn.colintree.aix.SwipeRefresh.SwipeRefresh");
    static final SimpleSymbol Lit125 = ((SimpleSymbol) new SimpleSymbol("Reload").readResolve());
    static final PairWithPosition Lit126 = PairWithPosition.make(Lit143, PairWithPosition.make(Lit143, LList.Empty, "/tmp/1589059009136_0.7462359350888935-0/youngandroidproject/../src/appinventor/ai_gumbraise/VAEUP/Accueil.yail", 979120), "/tmp/1589059009136_0.7462359350888935-0/youngandroidproject/../src/appinventor/ai_gumbraise/VAEUP/Accueil.yail", 979115);
    static final SimpleSymbol Lit127 = ((SimpleSymbol) new SimpleSymbol("SwipeRefresh1$Refresh").readResolve());
    static final SimpleSymbol Lit128 = ((SimpleSymbol) new SimpleSymbol("Refresh").readResolve());
    static final SimpleSymbol Lit129 = ((SimpleSymbol) new SimpleSymbol("get-simple-name").readResolve());
    static final SimpleSymbol Lit13 = ((SimpleSymbol) new SimpleSymbol("OpenScreenAnimation").readResolve());
    static final SimpleSymbol Lit130 = ((SimpleSymbol) new SimpleSymbol("android-log-form").readResolve());
    static final SimpleSymbol Lit131 = ((SimpleSymbol) new SimpleSymbol("add-to-form-environment").readResolve());
    static final SimpleSymbol Lit132 = ((SimpleSymbol) new SimpleSymbol("lookup-in-form-environment").readResolve());
    static final SimpleSymbol Lit133 = ((SimpleSymbol) new SimpleSymbol("is-bound-in-form-environment").readResolve());
    static final SimpleSymbol Lit134 = ((SimpleSymbol) new SimpleSymbol("add-to-global-var-environment").readResolve());
    static final SimpleSymbol Lit135 = ((SimpleSymbol) new SimpleSymbol("add-to-events").readResolve());
    static final SimpleSymbol Lit136 = ((SimpleSymbol) new SimpleSymbol("add-to-components").readResolve());
    static final SimpleSymbol Lit137 = ((SimpleSymbol) new SimpleSymbol("add-to-global-vars").readResolve());
    static final SimpleSymbol Lit138 = ((SimpleSymbol) new SimpleSymbol("add-to-form-do-after-creation").readResolve());
    static final SimpleSymbol Lit139 = ((SimpleSymbol) new SimpleSymbol("send-error").readResolve());
    static final SimpleSymbol Lit14 = ((SimpleSymbol) new SimpleSymbol("PrimaryColor").readResolve());
    static final SimpleSymbol Lit140 = ((SimpleSymbol) new SimpleSymbol("dispatchEvent").readResolve());
    static final SimpleSymbol Lit141 = ((SimpleSymbol) new SimpleSymbol("dispatchGenericEvent").readResolve());
    static final SimpleSymbol Lit142 = ((SimpleSymbol) new SimpleSymbol("lookup-handler").readResolve());
    static final SimpleSymbol Lit143 = ((SimpleSymbol) new SimpleSymbol("any").readResolve());
    static final IntNum Lit15;
    static final SimpleSymbol Lit16 = ((SimpleSymbol) new SimpleSymbol("PrimaryColorDark").readResolve());
    static final IntNum Lit17;
    static final SimpleSymbol Lit18 = ((SimpleSymbol) new SimpleSymbol("ScreenOrientation").readResolve());
    static final SimpleSymbol Lit19 = ((SimpleSymbol) new SimpleSymbol("ShowListsAsJson").readResolve());
    static final SimpleSymbol Lit2 = ((SimpleSymbol) new SimpleSymbol("*the-null-value*").readResolve());
    static final SimpleSymbol Lit20 = ((SimpleSymbol) new SimpleSymbol("Sizing").readResolve());
    static final SimpleSymbol Lit21 = ((SimpleSymbol) new SimpleSymbol("Theme").readResolve());
    static final SimpleSymbol Lit22 = ((SimpleSymbol) new SimpleSymbol("Title").readResolve());
    static final SimpleSymbol Lit23 = ((SimpleSymbol) new SimpleSymbol("TitleVisible").readResolve());
    static final SimpleSymbol Lit24 = ((SimpleSymbol) new SimpleSymbol("Label2").readResolve());
    static final SimpleSymbol Lit25 = ((SimpleSymbol) new SimpleSymbol("Text").readResolve());
    static final PairWithPosition Lit26;
    static final SimpleSymbol Lit27 = ((SimpleSymbol) new SimpleSymbol("SwipeRefresh1").readResolve());
    static final SimpleSymbol Lit28 = ((SimpleSymbol) new SimpleSymbol("RegisterArrangement").readResolve());
    static final SimpleSymbol Lit29 = ((SimpleSymbol) new SimpleSymbol("VerticalScrollArrangement1").readResolve());
    static final SimpleSymbol Lit3 = ((SimpleSymbol) new SimpleSymbol("AccentColor").readResolve());
    static final PairWithPosition Lit30 = PairWithPosition.make((SimpleSymbol) new SimpleSymbol("component").readResolve(), LList.Empty, "/tmp/1589059009136_0.7462359350888935-0/youngandroidproject/../src/appinventor/ai_gumbraise/VAEUP/Accueil.yail", 110879);
    static final SimpleSymbol Lit31 = ((SimpleSymbol) new SimpleSymbol("ColorList").readResolve());
    static final SimpleSymbol Lit32 = ((SimpleSymbol) new SimpleSymbol("_Color_holo_red_dark").readResolve());
    static final SimpleSymbol Lit33 = ((SimpleSymbol) new SimpleSymbol("_Color_holo_red_light").readResolve());
    static final PairWithPosition Lit34 = PairWithPosition.make(Lit143, PairWithPosition.make(Lit143, LList.Empty, "/tmp/1589059009136_0.7462359350888935-0/youngandroidproject/../src/appinventor/ai_gumbraise/VAEUP/Accueil.yail", 111180), "/tmp/1589059009136_0.7462359350888935-0/youngandroidproject/../src/appinventor/ai_gumbraise/VAEUP/Accueil.yail", 111175);
    static final SimpleSymbol Lit35 = ((SimpleSymbol) new SimpleSymbol("list").readResolve());
    static final SimpleSymbol Lit36 = ((SimpleSymbol) new SimpleSymbol("Accueil$Initialize").readResolve());
    static final SimpleSymbol Lit37 = ((SimpleSymbol) new SimpleSymbol("Initialize").readResolve());
    static final FString Lit38 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final SimpleSymbol Lit39 = ((SimpleSymbol) new SimpleSymbol("VerticalArrangement1").readResolve());
    static final IntNum Lit4;
    static final SimpleSymbol Lit40 = ((SimpleSymbol) new SimpleSymbol("AlignVertical").readResolve());
    static final IntNum Lit41 = IntNum.make(2);
    static final IntNum Lit42 = IntNum.make(16777215);
    static final SimpleSymbol Lit43 = ((SimpleSymbol) new SimpleSymbol("Height").readResolve());
    static final IntNum Lit44 = IntNum.make(60);
    static final SimpleSymbol Lit45 = ((SimpleSymbol) new SimpleSymbol("Width").readResolve());
    static final IntNum Lit46 = IntNum.make(-2);
    static final FString Lit47 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final FString Lit48 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit49 = ((SimpleSymbol) new SimpleSymbol("HorizontalArrangement1").readResolve());
    static final SimpleSymbol Lit5 = ((SimpleSymbol) new SimpleSymbol("number").readResolve());
    static final IntNum Lit50 = IntNum.make(40);
    static final FString Lit51 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit52 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final SimpleSymbol Lit53 = ((SimpleSymbol) new SimpleSymbol("VerticalArrangement3").readResolve());
    static final IntNum Lit54 = IntNum.make(10);
    static final FString Lit55 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final FString Lit56 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit57 = ((SimpleSymbol) new SimpleSymbol("HorizontalArrangement2").readResolve());
    static final SimpleSymbol Lit58 = ((SimpleSymbol) new SimpleSymbol("AlignHorizontal").readResolve());
    static final IntNum Lit59 = IntNum.make(3);
    static final SimpleSymbol Lit6 = ((SimpleSymbol) new SimpleSymbol("ActionBar").readResolve());
    static final IntNum Lit60 = IntNum.make(50);
    static final FString Lit61 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit62 = new FString("com.google.appinventor.components.runtime.Image");
    static final SimpleSymbol Lit63 = ((SimpleSymbol) new SimpleSymbol("Image1").readResolve());
    static final SimpleSymbol Lit64 = ((SimpleSymbol) new SimpleSymbol("Picture").readResolve());
    static final FString Lit65 = new FString("com.google.appinventor.components.runtime.Image");
    static final FString Lit66 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final SimpleSymbol Lit67 = ((SimpleSymbol) new SimpleSymbol("VerticalArrangement2").readResolve());
    static final FString Lit68 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final FString Lit69 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit7 = ((SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN).readResolve());
    static final SimpleSymbol Lit70 = ((SimpleSymbol) new SimpleSymbol("HorizontalArrangement3").readResolve());
    static final FString Lit71 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit72 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit73 = ((SimpleSymbol) new SimpleSymbol("FontBold").readResolve());
    static final SimpleSymbol Lit74 = ((SimpleSymbol) new SimpleSymbol("FontSize").readResolve());
    static final IntNum Lit75 = IntNum.make(24);
    static final SimpleSymbol Lit76 = ((SimpleSymbol) new SimpleSymbol("FontTypeface").readResolve());
    static final IntNum Lit77 = IntNum.make(1);
    static final SimpleSymbol Lit78 = ((SimpleSymbol) new SimpleSymbol("TextColor").readResolve());
    static final IntNum Lit79;
    static final SimpleSymbol Lit8 = ((SimpleSymbol) new SimpleSymbol("AppName").readResolve());
    static final FString Lit80 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit81 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final SimpleSymbol Lit82 = ((SimpleSymbol) new SimpleSymbol("VerticalArrangement4").readResolve());
    static final FString Lit83 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final FString Lit84 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit85 = ((SimpleSymbol) new SimpleSymbol("HorizontalArrangement4").readResolve());
    static final FString Lit86 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit87 = new FString("com.google.appinventor.components.runtime.Image");
    static final SimpleSymbol Lit88 = ((SimpleSymbol) new SimpleSymbol("Image2").readResolve());
    static final FString Lit89 = new FString("com.google.appinventor.components.runtime.Image");
    static final SimpleSymbol Lit9;
    static final FString Lit90 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final SimpleSymbol Lit91 = ((SimpleSymbol) new SimpleSymbol("VerticalArrangement5").readResolve());
    static final FString Lit92 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final FString Lit93 = new FString("com.google.appinventor.components.runtime.VerticalScrollArrangement");
    static final FString Lit94 = new FString("com.google.appinventor.components.runtime.VerticalScrollArrangement");
    static final FString Lit95 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit96 = ((SimpleSymbol) new SimpleSymbol("HorizontalArrangement5").readResolve());
    static final SimpleSymbol Lit97 = ((SimpleSymbol) new SimpleSymbol("Visible").readResolve());
    static final FString Lit98 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit99 = new FString("com.google.appinventor.components.runtime.Label");
    static final ModuleMethod lambda$Fn1 = null;
    static final ModuleMethod lambda$Fn10 = null;
    static final ModuleMethod lambda$Fn11 = null;
    static final ModuleMethod lambda$Fn12 = null;
    static final ModuleMethod lambda$Fn13 = null;
    static final ModuleMethod lambda$Fn14 = null;
    static final ModuleMethod lambda$Fn15 = null;
    static final ModuleMethod lambda$Fn16 = null;
    static final ModuleMethod lambda$Fn17 = null;
    static final ModuleMethod lambda$Fn18 = null;
    static final ModuleMethod lambda$Fn19 = null;
    static final ModuleMethod lambda$Fn2 = null;
    static final ModuleMethod lambda$Fn20 = null;
    static final ModuleMethod lambda$Fn21 = null;
    static final ModuleMethod lambda$Fn22 = null;
    static final ModuleMethod lambda$Fn23 = null;
    static final ModuleMethod lambda$Fn24 = null;
    static final ModuleMethod lambda$Fn25 = null;
    static final ModuleMethod lambda$Fn26 = null;
    static final ModuleMethod lambda$Fn27 = null;
    static final ModuleMethod lambda$Fn28 = null;
    static final ModuleMethod lambda$Fn29 = null;
    static final ModuleMethod lambda$Fn3 = null;
    static final ModuleMethod lambda$Fn30 = null;
    static final ModuleMethod lambda$Fn31 = null;
    static final ModuleMethod lambda$Fn32 = null;
    static final ModuleMethod lambda$Fn33 = null;
    static final ModuleMethod lambda$Fn34 = null;
    static final ModuleMethod lambda$Fn35 = null;
    static final ModuleMethod lambda$Fn36 = null;
    static final ModuleMethod lambda$Fn37 = null;
    static final ModuleMethod lambda$Fn38 = null;
    static final ModuleMethod lambda$Fn39 = null;
    static final ModuleMethod lambda$Fn4 = null;
    static final ModuleMethod lambda$Fn40 = null;
    static final ModuleMethod lambda$Fn5 = null;
    static final ModuleMethod lambda$Fn6 = null;
    static final ModuleMethod lambda$Fn7 = null;
    static final ModuleMethod lambda$Fn8 = null;
    static final ModuleMethod lambda$Fn9 = null;
    public Boolean $Stdebug$Mnform$St;
    public final ModuleMethod $define;
    public final ModuleMethod Accueil$Initialize;
    public HorizontalArrangement HorizontalArrangement1;
    public HorizontalArrangement HorizontalArrangement2;
    public HorizontalArrangement HorizontalArrangement3;
    public HorizontalArrangement HorizontalArrangement4;
    public HorizontalArrangement HorizontalArrangement5;
    public Image Image1;
    public Image Image2;
    public Label Label2;
    public Label Label3;
    public SwipeRefresh SwipeRefresh1;
    public final ModuleMethod SwipeRefresh1$Refresh;
    public TaifunImage TaifunImage1;
    public VerticalArrangement VerticalArrangement1;
    public VerticalArrangement VerticalArrangement2;
    public VerticalArrangement VerticalArrangement3;
    public VerticalArrangement VerticalArrangement4;
    public VerticalArrangement VerticalArrangement5;
    public VerticalArrangement VerticalArrangement6;
    public VerticalScrollArrangement VerticalScrollArrangement1;
    public VerticalScrollArrangement VerticalScrollArrangement2;
    public WebViewer WebViewer1;
    public final ModuleMethod WebViewer1$ErrorOccurred;
    public final ModuleMethod WebViewer1$PageLoaded;
    public final ModuleMethod add$Mnto$Mncomponents;
    public final ModuleMethod add$Mnto$Mnevents;
    public final ModuleMethod add$Mnto$Mnform$Mndo$Mnafter$Mncreation;
    public final ModuleMethod add$Mnto$Mnform$Mnenvironment;
    public final ModuleMethod add$Mnto$Mnglobal$Mnvar$Mnenvironment;
    public final ModuleMethod add$Mnto$Mnglobal$Mnvars;
    public final ModuleMethod android$Mnlog$Mnform;
    public LList components$Mnto$Mncreate;
    public final ModuleMethod dispatchEvent;
    public final ModuleMethod dispatchGenericEvent;
    public LList events$Mnto$Mnregister;
    public LList form$Mndo$Mnafter$Mncreation;
    public Environment form$Mnenvironment;
    public Symbol form$Mnname$Mnsymbol;
    public final ModuleMethod get$Mnsimple$Mnname;
    public Environment global$Mnvar$Mnenvironment;
    public LList global$Mnvars$Mnto$Mncreate;
    public final ModuleMethod is$Mnbound$Mnin$Mnform$Mnenvironment;
    public final ModuleMethod lookup$Mnhandler;
    public final ModuleMethod lookup$Mnin$Mnform$Mnenvironment;
    public final ModuleMethod onCreate;
    public final ModuleMethod process$Mnexception;
    public final ModuleMethod send$Mnerror;

    static {
        int[] iArr = new int[2];
        iArr[0] = -16777216;
        Lit123 = IntNum.make(iArr);
        int[] iArr2 = new int[2];
        iArr2[0] = -16776961;
        Lit117 = IntNum.make(iArr2);
        int[] iArr3 = new int[2];
        iArr3[0] = -1;
        Lit79 = IntNum.make(iArr3);
        SimpleSymbol simpleSymbol = (SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_TEXT).readResolve();
        Lit9 = simpleSymbol;
        Lit26 = PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1589059009136_0.7462359350888935-0/youngandroidproject/../src/appinventor/ai_gumbraise/VAEUP/Accueil.yail", 110732);
        int[] iArr4 = new int[2];
        iArr4[0] = -15395561;
        Lit17 = IntNum.make(iArr4);
        int[] iArr5 = new int[2];
        iArr5[0] = -15395561;
        Lit15 = IntNum.make(iArr5);
        int[] iArr6 = new int[2];
        iArr6[0] = -15395561;
        Lit11 = IntNum.make(iArr6);
        int[] iArr7 = new int[2];
        iArr7[0] = -1;
        Lit4 = IntNum.make(iArr7);
    }

    public Accueil() {
        ModuleInfo.register(this);
        frame frame2 = new frame();
        frame2.$main = this;
        this.get$Mnsimple$Mnname = new ModuleMethod(frame2, 1, Lit129, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.onCreate = new ModuleMethod(frame2, 2, "onCreate", FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.android$Mnlog$Mnform = new ModuleMethod(frame2, 3, Lit130, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.add$Mnto$Mnform$Mnenvironment = new ModuleMethod(frame2, 4, Lit131, 8194);
        this.lookup$Mnin$Mnform$Mnenvironment = new ModuleMethod(frame2, 5, Lit132, 8193);
        this.is$Mnbound$Mnin$Mnform$Mnenvironment = new ModuleMethod(frame2, 7, Lit133, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.add$Mnto$Mnglobal$Mnvar$Mnenvironment = new ModuleMethod(frame2, 8, Lit134, 8194);
        this.add$Mnto$Mnevents = new ModuleMethod(frame2, 9, Lit135, 8194);
        this.add$Mnto$Mncomponents = new ModuleMethod(frame2, 10, Lit136, 16388);
        this.add$Mnto$Mnglobal$Mnvars = new ModuleMethod(frame2, 11, Lit137, 8194);
        this.add$Mnto$Mnform$Mndo$Mnafter$Mncreation = new ModuleMethod(frame2, 12, Lit138, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.send$Mnerror = new ModuleMethod(frame2, 13, Lit139, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.process$Mnexception = new ModuleMethod(frame2, 14, "process-exception", FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.dispatchEvent = new ModuleMethod(frame2, 15, Lit140, 16388);
        this.dispatchGenericEvent = new ModuleMethod(frame2, 16, Lit141, 16388);
        this.lookup$Mnhandler = new ModuleMethod(frame2, 17, Lit142, 8194);
        ModuleMethod moduleMethod = new ModuleMethod(frame2, 18, (Object) null, 0);
        moduleMethod.setProperty("source-location", "/tmp/runtime8442570147866654509.scm:622");
        lambda$Fn1 = moduleMethod;
        this.$define = new ModuleMethod(frame2, 19, "$define", 0);
        lambda$Fn2 = new ModuleMethod(frame2, 20, (Object) null, 0);
        this.Accueil$Initialize = new ModuleMethod(frame2, 21, Lit36, 0);
        lambda$Fn3 = new ModuleMethod(frame2, 22, (Object) null, 0);
        lambda$Fn4 = new ModuleMethod(frame2, 23, (Object) null, 0);
        lambda$Fn5 = new ModuleMethod(frame2, 24, (Object) null, 0);
        lambda$Fn6 = new ModuleMethod(frame2, 25, (Object) null, 0);
        lambda$Fn7 = new ModuleMethod(frame2, 26, (Object) null, 0);
        lambda$Fn8 = new ModuleMethod(frame2, 27, (Object) null, 0);
        lambda$Fn9 = new ModuleMethod(frame2, 28, (Object) null, 0);
        lambda$Fn10 = new ModuleMethod(frame2, 29, (Object) null, 0);
        lambda$Fn11 = new ModuleMethod(frame2, 30, (Object) null, 0);
        lambda$Fn12 = new ModuleMethod(frame2, 31, (Object) null, 0);
        lambda$Fn13 = new ModuleMethod(frame2, 32, (Object) null, 0);
        lambda$Fn14 = new ModuleMethod(frame2, 33, (Object) null, 0);
        lambda$Fn15 = new ModuleMethod(frame2, 34, (Object) null, 0);
        lambda$Fn16 = new ModuleMethod(frame2, 35, (Object) null, 0);
        lambda$Fn17 = new ModuleMethod(frame2, 36, (Object) null, 0);
        lambda$Fn18 = new ModuleMethod(frame2, 37, (Object) null, 0);
        lambda$Fn19 = new ModuleMethod(frame2, 38, (Object) null, 0);
        lambda$Fn20 = new ModuleMethod(frame2, 39, (Object) null, 0);
        lambda$Fn21 = new ModuleMethod(frame2, 40, (Object) null, 0);
        lambda$Fn22 = new ModuleMethod(frame2, 41, (Object) null, 0);
        lambda$Fn23 = new ModuleMethod(frame2, 42, (Object) null, 0);
        lambda$Fn24 = new ModuleMethod(frame2, 43, (Object) null, 0);
        lambda$Fn25 = new ModuleMethod(frame2, 44, (Object) null, 0);
        lambda$Fn26 = new ModuleMethod(frame2, 45, (Object) null, 0);
        lambda$Fn27 = new ModuleMethod(frame2, 46, (Object) null, 0);
        lambda$Fn28 = new ModuleMethod(frame2, 47, (Object) null, 0);
        lambda$Fn29 = new ModuleMethod(frame2, 48, (Object) null, 0);
        lambda$Fn30 = new ModuleMethod(frame2, 49, (Object) null, 0);
        lambda$Fn31 = new ModuleMethod(frame2, 50, (Object) null, 0);
        lambda$Fn32 = new ModuleMethod(frame2, 51, (Object) null, 0);
        lambda$Fn33 = new ModuleMethod(frame2, 52, (Object) null, 0);
        lambda$Fn34 = new ModuleMethod(frame2, 53, (Object) null, 0);
        this.WebViewer1$ErrorOccurred = new ModuleMethod(frame2, 54, Lit107, 12291);
        this.WebViewer1$PageLoaded = new ModuleMethod(frame2, 55, Lit110, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        lambda$Fn35 = new ModuleMethod(frame2, 56, (Object) null, 0);
        lambda$Fn36 = new ModuleMethod(frame2, 57, (Object) null, 0);
        lambda$Fn37 = new ModuleMethod(frame2, 58, (Object) null, 0);
        lambda$Fn38 = new ModuleMethod(frame2, 59, (Object) null, 0);
        lambda$Fn39 = new ModuleMethod(frame2, 60, (Object) null, 0);
        lambda$Fn40 = new ModuleMethod(frame2, 61, (Object) null, 0);
        this.SwipeRefresh1$Refresh = new ModuleMethod(frame2, 62, Lit127, 0);
    }

    public Object lookupInFormEnvironment(Symbol symbol) {
        return lookupInFormEnvironment(symbol, Boolean.FALSE);
    }

    public void run() {
        CallContext instance = CallContext.getInstance();
        Consumer consumer = instance.consumer;
        instance.consumer = VoidConsumer.instance;
        try {
            run(instance);
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        ModuleBody.runCleanup(instance, th, consumer);
    }

    public final void run(CallContext $ctx) {
        String obj;
        Consumer $result = $ctx.consumer;
        Object find = require.find("com.google.youngandroid.runtime");
        try {
            ((Runnable) find).run();
            this.$Stdebug$Mnform$St = Boolean.FALSE;
            this.form$Mnenvironment = Environment.make(misc.symbol$To$String(Lit0));
            FString stringAppend = strings.stringAppend(misc.symbol$To$String(Lit0), "-global-vars");
            if (stringAppend == null) {
                obj = null;
            } else {
                obj = stringAppend.toString();
            }
            this.global$Mnvar$Mnenvironment = Environment.make(obj);
            Accueil = null;
            this.form$Mnname$Mnsymbol = Lit0;
            this.events$Mnto$Mnregister = LList.Empty;
            this.components$Mnto$Mncreate = LList.Empty;
            this.global$Mnvars$Mnto$Mncreate = LList.Empty;
            this.form$Mndo$Mnafter$Mncreation = LList.Empty;
            Object find2 = require.find("com.google.youngandroid.runtime");
            try {
                ((Runnable) find2).run();
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit3, Lit4, Lit5);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit6, Boolean.TRUE, Lit7);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit8, "VAEUP", Lit9);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit10, Lit11, Lit5);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit12, "none", Lit9);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit13, "none", Lit9);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit14, Lit15, Lit5);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit16, Lit17, Lit5);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit18, "portrait", Lit9);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit19, Boolean.TRUE, Lit7);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit20, "Responsive", Lit9);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit21, "AppTheme", Lit9);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit22, "Accueil", Lit9);
                    Values.writeValues(runtime.setAndCoerceProperty$Ex(Lit0, Lit23, Boolean.FALSE, Lit7), $result);
                } else {
                    addToFormDoAfterCreation(new Promise(lambda$Fn2));
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit36, this.Accueil$Initialize);
                } else {
                    addToFormEnvironment(Lit36, this.Accueil$Initialize);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Accueil", "Initialize");
                } else {
                    addToEvents(Lit0, Lit37);
                }
                this.VerticalArrangement1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit38, Lit39, lambda$Fn3), $result);
                } else {
                    addToComponents(Lit0, Lit47, Lit39, lambda$Fn4);
                }
                this.HorizontalArrangement1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit39, Lit48, Lit49, lambda$Fn5), $result);
                } else {
                    addToComponents(Lit39, Lit51, Lit49, lambda$Fn6);
                }
                this.VerticalArrangement3 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit49, Lit52, Lit53, lambda$Fn7), $result);
                } else {
                    addToComponents(Lit49, Lit55, Lit53, lambda$Fn8);
                }
                this.HorizontalArrangement2 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit49, Lit56, Lit57, lambda$Fn9), $result);
                } else {
                    addToComponents(Lit49, Lit61, Lit57, lambda$Fn10);
                }
                this.Image1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit57, Lit62, Lit63, lambda$Fn11), $result);
                } else {
                    addToComponents(Lit57, Lit65, Lit63, lambda$Fn12);
                }
                this.VerticalArrangement2 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit49, Lit66, Lit67, lambda$Fn13), $result);
                } else {
                    addToComponents(Lit49, Lit68, Lit67, lambda$Fn14);
                }
                this.HorizontalArrangement3 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit49, Lit69, Lit70, lambda$Fn15), $result);
                } else {
                    addToComponents(Lit49, Lit71, Lit70, lambda$Fn16);
                }
                this.Label2 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit70, Lit72, Lit24, lambda$Fn17), $result);
                } else {
                    addToComponents(Lit70, Lit80, Lit24, lambda$Fn18);
                }
                this.VerticalArrangement4 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit49, Lit81, Lit82, lambda$Fn19), $result);
                } else {
                    addToComponents(Lit49, Lit83, Lit82, lambda$Fn20);
                }
                this.HorizontalArrangement4 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit49, Lit84, Lit85, lambda$Fn21), $result);
                } else {
                    addToComponents(Lit49, Lit86, Lit85, lambda$Fn22);
                }
                this.Image2 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit85, Lit87, Lit88, lambda$Fn23), $result);
                } else {
                    addToComponents(Lit85, Lit89, Lit88, lambda$Fn24);
                }
                this.VerticalArrangement5 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit49, Lit90, Lit91, lambda$Fn25), $result);
                } else {
                    addToComponents(Lit49, Lit92, Lit91, lambda$Fn26);
                }
                this.VerticalScrollArrangement1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit93, Lit29, lambda$Fn27), $result);
                } else {
                    addToComponents(Lit0, Lit94, Lit29, lambda$Fn28);
                }
                this.HorizontalArrangement5 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit29, Lit95, Lit96, lambda$Fn29), $result);
                } else {
                    addToComponents(Lit29, Lit98, Lit96, lambda$Fn30);
                }
                this.Label3 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit96, Lit99, Lit100, lambda$Fn31), $result);
                } else {
                    addToComponents(Lit96, Lit102, Lit100, lambda$Fn32);
                }
                this.WebViewer1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit29, Lit103, Lit104, lambda$Fn33), $result);
                } else {
                    addToComponents(Lit29, Lit106, Lit104, lambda$Fn34);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit107, this.WebViewer1$ErrorOccurred);
                } else {
                    addToFormEnvironment(Lit107, this.WebViewer1$ErrorOccurred);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "WebViewer1", "ErrorOccurred");
                } else {
                    addToEvents(Lit104, Lit108);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit110, this.WebViewer1$PageLoaded);
                } else {
                    addToFormEnvironment(Lit110, this.WebViewer1$PageLoaded);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "WebViewer1", "PageLoaded");
                } else {
                    addToEvents(Lit104, Lit111);
                }
                this.VerticalScrollArrangement2 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit112, Lit113, lambda$Fn35), $result);
                } else {
                    addToComponents(Lit0, Lit114, Lit113, lambda$Fn36);
                }
                this.VerticalArrangement6 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit113, Lit115, Lit116, lambda$Fn37), $result);
                } else {
                    addToComponents(Lit113, Lit118, Lit116, lambda$Fn38);
                }
                this.TaifunImage1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit119, Lit120, Boolean.FALSE), $result);
                } else {
                    addToComponents(Lit0, Lit121, Lit120, Boolean.FALSE);
                }
                this.SwipeRefresh1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit122, Lit27, lambda$Fn39), $result);
                } else {
                    addToComponents(Lit0, Lit124, Lit27, lambda$Fn40);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit127, this.SwipeRefresh1$Refresh);
                } else {
                    addToFormEnvironment(Lit127, this.SwipeRefresh1$Refresh);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "SwipeRefresh1", "Refresh");
                } else {
                    addToEvents(Lit27, Lit128);
                }
                runtime.initRuntime();
            } catch (ClassCastException e) {
                throw new WrongType(e, "java.lang.Runnable.run()", 1, find2);
            }
        } catch (ClassCastException e2) {
            throw new WrongType(e2, "java.lang.Runnable.run()", 1, find);
        }
    }

    static Object lambda3() {
        runtime.setAndCoerceProperty$Ex(Lit0, Lit3, Lit4, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit6, Boolean.TRUE, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit8, "VAEUP", Lit9);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit10, Lit11, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit12, "none", Lit9);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit13, "none", Lit9);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit14, Lit15, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit16, Lit17, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit18, "portrait", Lit9);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit19, Boolean.TRUE, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit20, "Responsive", Lit9);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit21, "AppTheme", Lit9);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit22, "Accueil", Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit0, Lit23, Boolean.FALSE, Lit7);
    }

    public Object Accueil$Initialize() {
        runtime.setThisForm();
        runtime.setAndCoerceProperty$Ex(Lit24, Lit25, runtime.callYailPrimitive(runtime.string$Mnto$Mnupper$Mncase, LList.list1(runtime.getProperty$1(Lit0, Lit22)), Lit26, "upcase"), Lit9);
        runtime.callComponentMethod(Lit27, Lit28, LList.list1(runtime.lookupInCurrentFormEnvironment(Lit29)), Lit30);
        return runtime.setAndCoerceProperty$Ex(Lit27, Lit31, runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list2(runtime.callComponentMethod(Lit27, Lit32, LList.Empty, LList.Empty), runtime.callComponentMethod(Lit27, Lit33, LList.Empty, LList.Empty)), Lit34, "make a list"), Lit35);
    }

    static Object lambda4() {
        runtime.setAndCoerceProperty$Ex(Lit39, Lit40, Lit41, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit39, Lit10, Lit42, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit39, Lit43, Lit44, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit39, Lit45, Lit46, Lit5);
    }

    static Object lambda5() {
        runtime.setAndCoerceProperty$Ex(Lit39, Lit40, Lit41, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit39, Lit10, Lit42, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit39, Lit43, Lit44, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit39, Lit45, Lit46, Lit5);
    }

    static Object lambda6() {
        runtime.setAndCoerceProperty$Ex(Lit49, Lit40, Lit41, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit49, Lit43, Lit50, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit49, Lit45, Lit46, Lit5);
    }

    static Object lambda7() {
        runtime.setAndCoerceProperty$Ex(Lit49, Lit40, Lit41, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit49, Lit43, Lit50, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit49, Lit45, Lit46, Lit5);
    }

    static Object lambda8() {
        runtime.setAndCoerceProperty$Ex(Lit53, Lit43, Lit46, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit53, Lit45, Lit54, Lit5);
    }

    static Object lambda9() {
        runtime.setAndCoerceProperty$Ex(Lit53, Lit43, Lit46, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit53, Lit45, Lit54, Lit5);
    }

    static Object lambda10() {
        runtime.setAndCoerceProperty$Ex(Lit57, Lit58, Lit59, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit57, Lit40, Lit41, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit57, Lit43, Lit46, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit57, Lit45, Lit60, Lit5);
    }

    static Object lambda11() {
        runtime.setAndCoerceProperty$Ex(Lit57, Lit58, Lit59, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit57, Lit40, Lit41, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit57, Lit43, Lit46, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit57, Lit45, Lit60, Lit5);
    }

    static Object lambda12() {
        runtime.setAndCoerceProperty$Ex(Lit63, Lit43, Lit46, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit63, Lit64, "vaeup_logo_plain.png", Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit63, Lit45, Lit46, Lit5);
    }

    static Object lambda13() {
        runtime.setAndCoerceProperty$Ex(Lit63, Lit43, Lit46, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit63, Lit64, "vaeup_logo_plain.png", Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit63, Lit45, Lit46, Lit5);
    }

    static Object lambda14() {
        runtime.setAndCoerceProperty$Ex(Lit67, Lit43, Lit46, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit67, Lit45, Lit54, Lit5);
    }

    static Object lambda15() {
        runtime.setAndCoerceProperty$Ex(Lit67, Lit43, Lit46, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit67, Lit45, Lit54, Lit5);
    }

    static Object lambda16() {
        runtime.setAndCoerceProperty$Ex(Lit70, Lit40, Lit41, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit70, Lit43, Lit46, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit70, Lit45, Lit46, Lit5);
    }

    static Object lambda17() {
        runtime.setAndCoerceProperty$Ex(Lit70, Lit40, Lit41, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit70, Lit43, Lit46, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit70, Lit45, Lit46, Lit5);
    }

    static Object lambda18() {
        runtime.setAndCoerceProperty$Ex(Lit24, Lit73, Boolean.TRUE, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit24, Lit74, Lit75, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit24, Lit76, Lit77, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit24, Lit78, Lit79, Lit5);
    }

    static Object lambda19() {
        runtime.setAndCoerceProperty$Ex(Lit24, Lit73, Boolean.TRUE, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit24, Lit74, Lit75, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit24, Lit76, Lit77, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit24, Lit78, Lit79, Lit5);
    }

    static Object lambda20() {
        runtime.setAndCoerceProperty$Ex(Lit82, Lit43, Lit46, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit82, Lit45, Lit54, Lit5);
    }

    static Object lambda21() {
        runtime.setAndCoerceProperty$Ex(Lit82, Lit43, Lit46, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit82, Lit45, Lit54, Lit5);
    }

    static Object lambda22() {
        runtime.setAndCoerceProperty$Ex(Lit85, Lit43, Lit46, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit85, Lit45, Lit60, Lit5);
    }

    static Object lambda23() {
        runtime.setAndCoerceProperty$Ex(Lit85, Lit43, Lit46, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit85, Lit45, Lit60, Lit5);
    }

    static Object lambda24() {
        runtime.setAndCoerceProperty$Ex(Lit88, Lit43, Lit46, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit88, Lit64, "vaeup_logo_plain.png", Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit88, Lit45, Lit46, Lit5);
    }

    static Object lambda25() {
        runtime.setAndCoerceProperty$Ex(Lit88, Lit43, Lit46, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit88, Lit64, "vaeup_logo_plain.png", Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit88, Lit45, Lit46, Lit5);
    }

    static Object lambda26() {
        runtime.setAndCoerceProperty$Ex(Lit91, Lit43, Lit46, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit91, Lit45, Lit54, Lit5);
    }

    static Object lambda27() {
        runtime.setAndCoerceProperty$Ex(Lit91, Lit43, Lit46, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit91, Lit45, Lit54, Lit5);
    }

    static Object lambda28() {
        runtime.setAndCoerceProperty$Ex(Lit29, Lit58, Lit59, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit29, Lit43, Lit46, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit29, Lit45, Lit46, Lit5);
    }

    static Object lambda29() {
        runtime.setAndCoerceProperty$Ex(Lit29, Lit58, Lit59, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit29, Lit43, Lit46, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit29, Lit45, Lit46, Lit5);
    }

    static Object lambda30() {
        runtime.setAndCoerceProperty$Ex(Lit96, Lit58, Lit59, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit96, Lit40, Lit41, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit96, Lit43, Lit46, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit96, Lit97, Boolean.FALSE, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit96, Lit45, Lit46, Lit5);
    }

    static Object lambda31() {
        runtime.setAndCoerceProperty$Ex(Lit96, Lit58, Lit59, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit96, Lit40, Lit41, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit96, Lit43, Lit46, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit96, Lit97, Boolean.FALSE, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit96, Lit45, Lit46, Lit5);
    }

    static Object lambda32() {
        runtime.setAndCoerceProperty$Ex(Lit100, Lit74, Lit101, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit100, Lit25, "Aucun accès à Internet détecté", Lit9);
    }

    static Object lambda33() {
        runtime.setAndCoerceProperty$Ex(Lit100, Lit74, Lit101, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit100, Lit25, "Aucun accès à Internet détecté", Lit9);
    }

    static Object lambda34() {
        runtime.setAndCoerceProperty$Ex(Lit104, Lit105, "https://kellis.fr/", Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit104, Lit45, Lit46, Lit5);
    }

    static Object lambda35() {
        runtime.setAndCoerceProperty$Ex(Lit104, Lit105, "https://kellis.fr/", Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit104, Lit45, Lit46, Lit5);
    }

    public Object WebViewer1$ErrorOccurred(Object $errorCode, Object $description, Object $failingUrl) {
        runtime.sanitizeComponentData($errorCode);
        runtime.sanitizeComponentData($description);
        runtime.sanitizeComponentData($failingUrl);
        runtime.setThisForm();
        runtime.setAndCoerceProperty$Ex(Lit104, Lit97, Boolean.FALSE, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit96, Lit97, Boolean.TRUE, Lit7);
    }

    public Object WebViewer1$PageLoaded(Object $url) {
        runtime.sanitizeComponentData($url);
        runtime.setThisForm();
        return runtime.callComponentMethod(Lit27, Lit109, LList.Empty, LList.Empty);
    }

    static Object lambda36() {
        runtime.setAndCoerceProperty$Ex(Lit113, Lit58, Lit59, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit113, Lit45, Lit46, Lit5);
    }

    static Object lambda37() {
        runtime.setAndCoerceProperty$Ex(Lit113, Lit58, Lit59, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit113, Lit45, Lit46, Lit5);
    }

    static Object lambda38() {
        runtime.setAndCoerceProperty$Ex(Lit116, Lit40, Lit41, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit116, Lit10, Lit117, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit116, Lit43, Lit50, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit116, Lit45, Lit46, Lit5);
    }

    static Object lambda39() {
        runtime.setAndCoerceProperty$Ex(Lit116, Lit40, Lit41, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit116, Lit10, Lit117, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit116, Lit43, Lit50, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit116, Lit45, Lit46, Lit5);
    }

    static Object lambda40() {
        return runtime.setAndCoerceProperty$Ex(Lit27, Lit10, Lit123, Lit5);
    }

    static Object lambda41() {
        return runtime.setAndCoerceProperty$Ex(Lit27, Lit10, Lit123, Lit5);
    }

    public Object SwipeRefresh1$Refresh() {
        runtime.setThisForm();
        runtime.callComponentMethod(Lit104, Lit125, LList.Empty, LList.Empty);
        return runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.getProperty$1(Lit104, Lit97), Boolean.FALSE), Lit126, "=") != Boolean.FALSE ? runtime.setAndCoerceProperty$Ex(Lit104, Lit97, Boolean.TRUE, Lit7) : Values.empty;
    }

    /* compiled from: Accueil.yail */
    public class frame extends ModuleBody {
        Accueil $main;

        public Object apply3(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3) {
            return moduleMethod.selector == 54 ? this.$main.WebViewer1$ErrorOccurred(obj, obj2, obj3) : super.apply3(moduleMethod, obj, obj2, obj3);
        }

        public int match3(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3, CallContext callContext) {
            if (moduleMethod.selector != 54) {
                return super.match3(moduleMethod, obj, obj2, obj3, callContext);
            }
            callContext.value1 = obj;
            callContext.value2 = obj2;
            callContext.value3 = obj3;
            callContext.proc = moduleMethod;
            callContext.pc = 3;
            return 0;
        }

        public int match1(ModuleMethod moduleMethod, Object obj, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 1:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 2:
                    if (!(obj instanceof Accueil)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 3:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 5:
                    if (!(obj instanceof Symbol)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 7:
                    if (!(obj instanceof Symbol)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 12:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 13:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 14:
                    if (!(obj instanceof Accueil)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 55:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                default:
                    return super.match1(moduleMethod, obj, callContext);
            }
        }

        public int match2(ModuleMethod moduleMethod, Object obj, Object obj2, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 4:
                    if (!(obj instanceof Symbol)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 5:
                    if (!(obj instanceof Symbol)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 8:
                    if (!(obj instanceof Symbol)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 9:
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 11:
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 17:
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                default:
                    return super.match2(moduleMethod, obj, obj2, callContext);
            }
        }

        public int match4(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3, Object obj4, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 10:
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.value3 = obj3;
                    callContext.value4 = obj4;
                    callContext.proc = moduleMethod;
                    callContext.pc = 4;
                    return 0;
                case 15:
                    if (!(obj instanceof Accueil)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    if (!(obj2 instanceof Component)) {
                        return -786430;
                    }
                    callContext.value2 = obj2;
                    if (!(obj3 instanceof String)) {
                        return -786429;
                    }
                    callContext.value3 = obj3;
                    if (!(obj4 instanceof String)) {
                        return -786428;
                    }
                    callContext.value4 = obj4;
                    callContext.proc = moduleMethod;
                    callContext.pc = 4;
                    return 0;
                case 16:
                    if (!(obj instanceof Accueil)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    if (!(obj2 instanceof Component)) {
                        return -786430;
                    }
                    callContext.value2 = obj2;
                    if (!(obj3 instanceof String)) {
                        return -786429;
                    }
                    callContext.value3 = obj3;
                    callContext.value4 = obj4;
                    callContext.proc = moduleMethod;
                    callContext.pc = 4;
                    return 0;
                default:
                    return super.match4(moduleMethod, obj, obj2, obj3, obj4, callContext);
            }
        }

        public Object apply1(ModuleMethod moduleMethod, Object obj) {
            switch (moduleMethod.selector) {
                case 1:
                    return this.$main.getSimpleName(obj);
                case 2:
                    try {
                        this.$main.onCreate((Bundle) obj);
                        return Values.empty;
                    } catch (ClassCastException e) {
                        throw new WrongType(e, "onCreate", 1, obj);
                    }
                case 3:
                    this.$main.androidLogForm(obj);
                    return Values.empty;
                case 5:
                    try {
                        return this.$main.lookupInFormEnvironment((Symbol) obj);
                    } catch (ClassCastException e2) {
                        throw new WrongType(e2, "lookup-in-form-environment", 1, obj);
                    }
                case 7:
                    try {
                        return this.$main.isBoundInFormEnvironment((Symbol) obj) ? Boolean.TRUE : Boolean.FALSE;
                    } catch (ClassCastException e3) {
                        throw new WrongType(e3, "is-bound-in-form-environment", 1, obj);
                    }
                case 12:
                    this.$main.addToFormDoAfterCreation(obj);
                    return Values.empty;
                case 13:
                    this.$main.sendError(obj);
                    return Values.empty;
                case 14:
                    this.$main.processException(obj);
                    return Values.empty;
                case 55:
                    return this.$main.WebViewer1$PageLoaded(obj);
                default:
                    return super.apply1(moduleMethod, obj);
            }
        }

        public Object apply4(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3, Object obj4) {
            boolean z = true;
            switch (moduleMethod.selector) {
                case 10:
                    this.$main.addToComponents(obj, obj2, obj3, obj4);
                    return Values.empty;
                case 15:
                    try {
                        try {
                            try {
                                try {
                                    return this.$main.dispatchEvent((Component) obj, (String) obj2, (String) obj3, (Object[]) obj4) ? Boolean.TRUE : Boolean.FALSE;
                                } catch (ClassCastException e) {
                                    throw new WrongType(e, "dispatchEvent", 4, obj4);
                                }
                            } catch (ClassCastException e2) {
                                throw new WrongType(e2, "dispatchEvent", 3, obj3);
                            }
                        } catch (ClassCastException e3) {
                            throw new WrongType(e3, "dispatchEvent", 2, obj2);
                        }
                    } catch (ClassCastException e4) {
                        throw new WrongType(e4, "dispatchEvent", 1, obj);
                    }
                case 16:
                    Accueil accueil = this.$main;
                    try {
                        Component component = (Component) obj;
                        try {
                            String str = (String) obj2;
                            try {
                                if (obj3 == Boolean.FALSE) {
                                    z = false;
                                }
                                try {
                                    accueil.dispatchGenericEvent(component, str, z, (Object[]) obj4);
                                    return Values.empty;
                                } catch (ClassCastException e5) {
                                    throw new WrongType(e5, "dispatchGenericEvent", 4, obj4);
                                }
                            } catch (ClassCastException e6) {
                                throw new WrongType(e6, "dispatchGenericEvent", 3, obj3);
                            }
                        } catch (ClassCastException e7) {
                            throw new WrongType(e7, "dispatchGenericEvent", 2, obj2);
                        }
                    } catch (ClassCastException e8) {
                        throw new WrongType(e8, "dispatchGenericEvent", 1, obj);
                    }
                default:
                    return super.apply4(moduleMethod, obj, obj2, obj3, obj4);
            }
        }

        public Object apply2(ModuleMethod moduleMethod, Object obj, Object obj2) {
            switch (moduleMethod.selector) {
                case 4:
                    try {
                        this.$main.addToFormEnvironment((Symbol) obj, obj2);
                        return Values.empty;
                    } catch (ClassCastException e) {
                        throw new WrongType(e, "add-to-form-environment", 1, obj);
                    }
                case 5:
                    try {
                        return this.$main.lookupInFormEnvironment((Symbol) obj, obj2);
                    } catch (ClassCastException e2) {
                        throw new WrongType(e2, "lookup-in-form-environment", 1, obj);
                    }
                case 8:
                    try {
                        this.$main.addToGlobalVarEnvironment((Symbol) obj, obj2);
                        return Values.empty;
                    } catch (ClassCastException e3) {
                        throw new WrongType(e3, "add-to-global-var-environment", 1, obj);
                    }
                case 9:
                    this.$main.addToEvents(obj, obj2);
                    return Values.empty;
                case 11:
                    this.$main.addToGlobalVars(obj, obj2);
                    return Values.empty;
                case 17:
                    return this.$main.lookupHandler(obj, obj2);
                default:
                    return super.apply2(moduleMethod, obj, obj2);
            }
        }

        public Object apply0(ModuleMethod moduleMethod) {
            switch (moduleMethod.selector) {
                case 18:
                    return Accueil.lambda2();
                case 19:
                    this.$main.$define();
                    return Values.empty;
                case 20:
                    return Accueil.lambda3();
                case 21:
                    return this.$main.Accueil$Initialize();
                case 22:
                    return Accueil.lambda4();
                case 23:
                    return Accueil.lambda5();
                case 24:
                    return Accueil.lambda6();
                case 25:
                    return Accueil.lambda7();
                case 26:
                    return Accueil.lambda8();
                case 27:
                    return Accueil.lambda9();
                case 28:
                    return Accueil.lambda10();
                case 29:
                    return Accueil.lambda11();
                case 30:
                    return Accueil.lambda12();
                case 31:
                    return Accueil.lambda13();
                case 32:
                    return Accueil.lambda14();
                case 33:
                    return Accueil.lambda15();
                case 34:
                    return Accueil.lambda16();
                case 35:
                    return Accueil.lambda17();
                case 36:
                    return Accueil.lambda18();
                case 37:
                    return Accueil.lambda19();
                case 38:
                    return Accueil.lambda20();
                case 39:
                    return Accueil.lambda21();
                case 40:
                    return Accueil.lambda22();
                case 41:
                    return Accueil.lambda23();
                case 42:
                    return Accueil.lambda24();
                case 43:
                    return Accueil.lambda25();
                case 44:
                    return Accueil.lambda26();
                case 45:
                    return Accueil.lambda27();
                case 46:
                    return Accueil.lambda28();
                case 47:
                    return Accueil.lambda29();
                case 48:
                    return Accueil.lambda30();
                case 49:
                    return Accueil.lambda31();
                case 50:
                    return Accueil.lambda32();
                case 51:
                    return Accueil.lambda33();
                case 52:
                    return Accueil.lambda34();
                case 53:
                    return Accueil.lambda35();
                case 56:
                    return Accueil.lambda36();
                case 57:
                    return Accueil.lambda37();
                case 58:
                    return Accueil.lambda38();
                case 59:
                    return Accueil.lambda39();
                case 60:
                    return Accueil.lambda40();
                case 61:
                    return Accueil.lambda41();
                case 62:
                    return this.$main.SwipeRefresh1$Refresh();
                default:
                    return super.apply0(moduleMethod);
            }
        }

        public int match0(ModuleMethod moduleMethod, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 18:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 19:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 20:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 21:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 22:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 23:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 24:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 25:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 26:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 27:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 28:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 29:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 30:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 31:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 32:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 33:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 34:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 35:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 36:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 37:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 38:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 39:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 40:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 41:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 42:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 43:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 44:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 45:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 46:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 47:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 48:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 49:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 50:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 51:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 52:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 53:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 56:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 57:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 58:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 59:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 60:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 61:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 62:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                default:
                    return super.match0(moduleMethod, callContext);
            }
        }
    }

    public String getSimpleName(Object object) {
        return object.getClass().getSimpleName();
    }

    public void onCreate(Bundle icicle) {
        AppInventorCompatActivity.setClassicModeFromYail(false);
        super.onCreate(icicle);
    }

    public void androidLogForm(Object message) {
    }

    public void addToFormEnvironment(Symbol name, Object object) {
        androidLogForm(Format.formatToString(0, "Adding ~A to env ~A with value ~A", name, this.form$Mnenvironment, object));
        this.form$Mnenvironment.put(name, object);
    }

    public Object lookupInFormEnvironment(Symbol name, Object default$Mnvalue) {
        boolean x = ((this.form$Mnenvironment == null ? 1 : 0) + 1) & true;
        if (x) {
            if (!this.form$Mnenvironment.isBound(name)) {
                return default$Mnvalue;
            }
        } else if (!x) {
            return default$Mnvalue;
        }
        return this.form$Mnenvironment.get(name);
    }

    public boolean isBoundInFormEnvironment(Symbol name) {
        return this.form$Mnenvironment.isBound(name);
    }

    public void addToGlobalVarEnvironment(Symbol name, Object object) {
        androidLogForm(Format.formatToString(0, "Adding ~A to env ~A with value ~A", name, this.global$Mnvar$Mnenvironment, object));
        this.global$Mnvar$Mnenvironment.put(name, object);
    }

    public void addToEvents(Object component$Mnname, Object event$Mnname) {
        this.events$Mnto$Mnregister = lists.cons(lists.cons(component$Mnname, event$Mnname), this.events$Mnto$Mnregister);
    }

    public void addToComponents(Object container$Mnname, Object component$Mntype, Object component$Mnname, Object init$Mnthunk) {
        this.components$Mnto$Mncreate = lists.cons(LList.list4(container$Mnname, component$Mntype, component$Mnname, init$Mnthunk), this.components$Mnto$Mncreate);
    }

    public void addToGlobalVars(Object var, Object val$Mnthunk) {
        this.global$Mnvars$Mnto$Mncreate = lists.cons(LList.list2(var, val$Mnthunk), this.global$Mnvars$Mnto$Mncreate);
    }

    public void addToFormDoAfterCreation(Object thunk) {
        this.form$Mndo$Mnafter$Mncreation = lists.cons(thunk, this.form$Mndo$Mnafter$Mncreation);
    }

    public void sendError(Object error) {
        RetValManager.sendError(error == null ? null : error.toString());
    }

    public void processException(Object ex) {
        Object apply1 = Scheme.applyToArgs.apply1(GetNamedPart.getNamedPart.apply2(ex, Lit1));
        RuntimeErrorAlert.alert(this, apply1 == null ? null : apply1.toString(), ex instanceof YailRuntimeError ? ((YailRuntimeError) ex).getErrorType() : "Runtime Error", "End Application");
    }

    public boolean dispatchEvent(Component componentObject, String registeredComponentName, String eventName, Object[] args) {
        boolean x;
        SimpleSymbol registeredObject = misc.string$To$Symbol(registeredComponentName);
        if (!isBoundInFormEnvironment(registeredObject)) {
            EventDispatcher.unregisterEventForDelegation(this, registeredComponentName, eventName);
            return false;
        } else if (lookupInFormEnvironment(registeredObject) != componentObject) {
            return false;
        } else {
            try {
                Scheme.apply.apply2(lookupHandler(registeredComponentName, eventName), LList.makeList(args, 0));
                return true;
            } catch (PermissionException exception) {
                exception.printStackTrace();
                if (this == componentObject) {
                    x = true;
                } else {
                    x = false;
                }
                if (!x ? x : IsEqual.apply(eventName, "PermissionNeeded")) {
                    processException(exception);
                } else {
                    PermissionDenied(componentObject, eventName, exception.getPermissionNeeded());
                }
                return false;
            } catch (Throwable exception2) {
                androidLogForm(exception2.getMessage());
                exception2.printStackTrace();
                processException(exception2);
                return false;
            }
        }
    }

    public void dispatchGenericEvent(Component componentObject, String eventName, boolean notAlreadyHandled, Object[] args) {
        Boolean bool;
        boolean x = true;
        Object handler = lookupInFormEnvironment(misc.string$To$Symbol(strings.stringAppend("any$", getSimpleName(componentObject), "$", eventName)));
        if (handler != Boolean.FALSE) {
            try {
                Apply apply = Scheme.apply;
                if (notAlreadyHandled) {
                    bool = Boolean.TRUE;
                } else {
                    bool = Boolean.FALSE;
                }
                apply.apply2(handler, lists.cons(componentObject, lists.cons(bool, LList.makeList(args, 0))));
            } catch (PermissionException exception) {
                exception.printStackTrace();
                if (this != componentObject) {
                    x = false;
                }
                if (!x ? x : IsEqual.apply(eventName, "PermissionNeeded")) {
                    processException(exception);
                } else {
                    PermissionDenied(componentObject, eventName, exception.getPermissionNeeded());
                }
            } catch (Throwable exception2) {
                androidLogForm(exception2.getMessage());
                exception2.printStackTrace();
                processException(exception2);
            }
        }
    }

    public Object lookupHandler(Object componentName, Object eventName) {
        String str = null;
        String obj = componentName == null ? null : componentName.toString();
        if (eventName != null) {
            str = eventName.toString();
        }
        return lookupInFormEnvironment(misc.string$To$Symbol(EventDispatcher.makeFullEventName(obj, str)));
    }

    public void $define() {
        Object reverse;
        Object obj;
        Object reverse2;
        Object obj2;
        Object obj3;
        Object var;
        Object component$Mnname;
        Object obj4;
        Language.setDefaults(Scheme.getInstance());
        try {
            run();
        } catch (Exception exception) {
            androidLogForm(exception.getMessage());
            processException(exception);
        }
        Accueil = this;
        addToFormEnvironment(Lit0, this);
        Object obj5 = this.events$Mnto$Mnregister;
        while (obj5 != LList.Empty) {
            try {
                Pair arg0 = (Pair) obj5;
                Object event$Mninfo = arg0.getCar();
                Object apply1 = lists.car.apply1(event$Mninfo);
                String obj6 = apply1 == null ? null : apply1.toString();
                Object apply12 = lists.cdr.apply1(event$Mninfo);
                EventDispatcher.registerEventForDelegation(this, obj6, apply12 == null ? null : apply12.toString());
                obj5 = arg0.getCdr();
            } catch (ClassCastException e) {
                throw new WrongType(e, "arg0", -2, obj5);
            }
        }
        try {
            LList components = lists.reverse(this.components$Mnto$Mncreate);
            addToGlobalVars(Lit2, lambda$Fn1);
            reverse = lists.reverse(this.form$Mndo$Mnafter$Mncreation);
            while (reverse != LList.Empty) {
                Pair arg02 = (Pair) reverse;
                misc.force(arg02.getCar());
                reverse = arg02.getCdr();
            }
            obj = components;
            while (obj != LList.Empty) {
                Pair arg03 = (Pair) obj;
                Object component$Mninfo = arg03.getCar();
                component$Mnname = lists.caddr.apply1(component$Mninfo);
                lists.cadddr.apply1(component$Mninfo);
                Object component$Mnobject = Invoke.make.apply2(lists.cadr.apply1(component$Mninfo), lookupInFormEnvironment((Symbol) lists.car.apply1(component$Mninfo)));
                SlotSet.set$Mnfield$Ex.apply3(this, component$Mnname, component$Mnobject);
                addToFormEnvironment((Symbol) component$Mnname, component$Mnobject);
                obj = arg03.getCdr();
            }
            reverse2 = lists.reverse(this.global$Mnvars$Mnto$Mncreate);
            while (reverse2 != LList.Empty) {
                Pair arg04 = (Pair) reverse2;
                Object var$Mnval = arg04.getCar();
                var = lists.car.apply1(var$Mnval);
                addToGlobalVarEnvironment((Symbol) var, Scheme.applyToArgs.apply1(lists.cadr.apply1(var$Mnval)));
                reverse2 = arg04.getCdr();
            }
            LList component$Mndescriptors = components;
            obj2 = component$Mndescriptors;
            while (obj2 != LList.Empty) {
                Pair arg05 = (Pair) obj2;
                Object component$Mninfo2 = arg05.getCar();
                lists.caddr.apply1(component$Mninfo2);
                Object init$Mnthunk = lists.cadddr.apply1(component$Mninfo2);
                if (init$Mnthunk != Boolean.FALSE) {
                    Scheme.applyToArgs.apply1(init$Mnthunk);
                }
                obj2 = arg05.getCdr();
            }
            obj3 = component$Mndescriptors;
            while (obj3 != LList.Empty) {
                Pair arg06 = (Pair) obj3;
                Object component$Mninfo3 = arg06.getCar();
                Object component$Mnname2 = lists.caddr.apply1(component$Mninfo3);
                lists.cadddr.apply1(component$Mninfo3);
                callInitialize(SlotGet.field.apply2(this, component$Mnname2));
                obj3 = arg06.getCdr();
            }
        } catch (ClassCastException e2) {
            throw new WrongType(e2, "arg0", -2, obj3);
        } catch (ClassCastException e3) {
            throw new WrongType(e3, "arg0", -2, obj2);
        } catch (ClassCastException e4) {
            throw new WrongType(e4, "add-to-global-var-environment", 0, var);
        } catch (ClassCastException e5) {
            throw new WrongType(e5, "arg0", -2, reverse2);
        } catch (ClassCastException e6) {
            throw new WrongType(e6, "add-to-form-environment", 0, component$Mnname);
        } catch (ClassCastException e7) {
            throw new WrongType(e7, "lookup-in-form-environment", 0, obj4);
        } catch (ClassCastException e8) {
            throw new WrongType(e8, "arg0", -2, obj);
        } catch (ClassCastException e9) {
            throw new WrongType(e9, "arg0", -2, reverse);
        } catch (YailRuntimeError exception2) {
            processException(exception2);
        }
    }

    public static SimpleSymbol lambda1symbolAppend$V(Object[] argsArray) {
        LList symbols = LList.makeList(argsArray, 0);
        Apply apply = Scheme.apply;
        ModuleMethod moduleMethod = strings.string$Mnappend;
        Object obj = LList.Empty;
        LList lList = symbols;
        while (lList != LList.Empty) {
            try {
                Pair arg0 = (Pair) lList;
                Object arg02 = arg0.getCdr();
                Object car = arg0.getCar();
                try {
                    obj = Pair.make(misc.symbol$To$String((Symbol) car), obj);
                    lList = arg02;
                } catch (ClassCastException e) {
                    throw new WrongType(e, "symbol->string", 1, car);
                }
            } catch (ClassCastException e2) {
                throw new WrongType(e2, "arg0", -2, lList);
            }
        }
        Object apply2 = apply.apply2(moduleMethod, LList.reverseInPlace(obj));
        try {
            return misc.string$To$Symbol((CharSequence) apply2);
        } catch (ClassCastException e3) {
            throw new WrongType(e3, "string->symbol", 1, apply2);
        }
    }

    static Object lambda2() {
        return null;
    }
}
