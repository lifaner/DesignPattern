package ProxyPattern2;

import org.apache.commons.io.FileUtils;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Proxy {

    public static Object newInstance(Class infce,InvocationHandler handler) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        
        String rn = "\r\n";

        String methodStr = "";
        for(Method m : infce.getMethods()){
            methodStr += "" +
            "    @Override" + rn +
            "    public void " + m.getName() + "() {" + rn +
                    "try{" + rn +
            "        Method md = " + infce.getName() + ".class.getMethod(\"" + m.getName() + "\");" + rn +
            "        h.invoke(this,md);" + rn +
                    "}catch(Exception e){" + rn +
                    "  e.printStackTrace();" + rn +
                    "}" + rn +
            "    }";
        }

        String str = " " +
            "package ProxyPattern2;" + rn +
            "import java.lang.reflect.Method;" + rn +
            "public class $Proxy0 implements " + infce.getName() + " {" + rn +
            "    private InvocationHandler h;" +  rn +
            "    public $Proxy0(InvocationHandler h){" + rn +
            "        this.h = h;" + rn +
            "    }" + rn + methodStr +
            "}";

        //将String写入文件
        String fileName = System.getProperty("user.dir") + "/out/production/DesignPattern/ProxyPattern2/$Proxy0.java";
        File file = new File(fileName);
        FileUtils.writeStringToFile(file,str,"UTF-8");

        //拿到编译器
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        JavaCompiler.CompilationTask task = compiler.getTask(null,fileManager,null,null,null,fileManager.getJavaFileObjects(fileName));
        //编译
        task.call();
        fileManager.close();

        //写入内存
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class clz = loader.loadClass("ProxyPattern2.$Proxy0");
        Constructor construct = clz.getConstructor(InvocationHandler.class);
        return construct.newInstance(handler);
    }
}
