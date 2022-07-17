package examples.concurrency.executor;

import java.util.concurrent.Executor;

public class EsecutoreThread implements Executor{

	@Override
	public void execute(Runnable command) {
		command.run();
	}

}
