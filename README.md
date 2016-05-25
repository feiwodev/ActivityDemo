# ActivityDemo
Android开发艺术探索，脑图笔记 part 1 项目Demo

配合part 1 脑图食用更佳 

脑图地址 ：[AndroidDevelopmentArt](https://github.com/zhuyongit/AndroidDevelopmentArt)

概要：

``` java
   /**
     * 隐式调用
     * @param view
     */
    public void filterOnClick(View view)
    {
        Intent intent = new Intent();
        /**
         * 过滤规则中有多个action ，只要有一个与之相同，则可匹配成功
         * intent 必须有action ， category 可以没有
         */
        intent.setAction("com.zeno.secondActivity") ;
        intent.setAction("com.zeno.secondActivity2") ;
        // 如果过滤规则没有此action则不能调用成功
        // intent 可以有多个action ， 但都必须和过滤规则匹配
//        intent.setAction("com.zeno.sec") ;
        intent.setDataAndType(Uri.parse("http://www.baidu.com"),"text/plan") ;
        /**
         * category 可以没有 , 一旦有就必须和过滤规则一致
         */
        intent.addCategory("com.zeno.info") ;
        // 使用隐式调用时，需要判断调用的Activity是否存在
        if (intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }else {
            Log.e(TAG,"invoke activity not found") ;
        }
    }
```
