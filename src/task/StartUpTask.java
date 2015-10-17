package task;
import java.util.TimerTask;

import com.opensymphony.xwork2.ActionContext;

import main.src.common.TimeManager;

public class StartUpTask extends TimerTask {

	public StartUpTask(ActionContext acx){
		
	}
	public StartUpTask(){
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method sub
		System.out.println("开始执行任务啦 " + TimeManager.getTime());
	}

}
