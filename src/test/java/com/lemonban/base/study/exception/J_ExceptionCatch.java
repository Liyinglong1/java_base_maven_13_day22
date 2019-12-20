package com.lemonban.base.study.exception;

public class J_ExceptionCatch
{
    public static void main(String args[]){
    	int[] a = new int[5];
    	System.out.println();
        try
        {
            System.out.println("try语句块");
            throw new Exception( );
        }
        catch(Exception e)
        {
            System.err.println("catch语句块");
            e.printStackTrace( );
        }
        finally
        {
            System.out.println("finally语句块");
        } // try-catch-finally结构结束
    } // 方法main结束
} // 类J_ExceptionCatch结束
 
/*运行流程：
1.try语句块捕捉throw的异常
2.跳转到相关的catch语句块
3.最后执行finally语句块的内容
*/