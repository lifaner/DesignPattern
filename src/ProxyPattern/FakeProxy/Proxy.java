package ProxyPattern.FakeProxy;

import ProxyPattern.Car;
import org.apache.commons.io.FileUtils;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Proxy {

    public static Object newInstance(Class infce,InvocationHandler handler) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        String methodStr = "";
        for(Method m : infce.getMethods()){
            methodStr += "\n" +
                    "    @Override\n" +
                    "    public void " + m.getName() + "() {\n" +
                    "       try{" +
                    "       Method md = " + infce.getName() + ".class.getMethod(\"" + m.getName() + "\");"+
                    " \n" +
                    "       h.invoke(this,md);\n" +
                    "       }catch(Exception e){\n" +
                    "           e.printStackTrace();" +
                    "       }" +
                    " \n" +
                    "    }\n" ;
        }

        String str = "" +
            "package ProxyPattern.FakeProxy;\n" +
            "import java.lang.reflect.Method;\n " +
            "\n" +
            "public class $Proxy0 implements " + infce.getName() + " { \n" +
            "\n" +
            "    public $Proxy0(InvocationHandler  h){\n" +
            "        this.h = h;\n" +
            "\n" +
            "    }\n" +
            "    private InvocationHandler h;\n" +
            methodStr +
            "}\n";

        String filename = System.getProperty("user.dir") + "/out/production/DesignPattern/ProxyPattern/FakeProxy/$Proxy0.java";
        File file = new File(filename);
        FileUtils.writeStringToFile(file,str,"UTF-8");

        //拿到编译器
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        //文件管理者
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null,null,null);

        //获取文件
        Iterable<? extends JavaFileObject> units = fileManager.getJavaFileObjects(filename);

        //编译任务
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, null, null, units);
        task.call();
        fileManager.close();

        //load 到内存当中
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        Class cls = cl.loadClass("ProxyPattern.FakeProxy.$Proxy0");

        //返回代理类
        Constructor constructor = cls.getConstructor(InvocationHandler.class);
        //返回动态代理类
        return  constructor.newInstance(handler) ;
    }
}
