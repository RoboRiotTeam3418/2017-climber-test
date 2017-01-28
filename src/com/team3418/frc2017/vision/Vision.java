package com.team3418.frc2017.vision;


import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import edu.wpi.cscore.AxisCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionRunner;
import edu.wpi.first.wpilibj.vision.VisionThread;

public class Vision {
	
	
	static Vision mInstance = new Vision();

    public static Vision getInstance() {
        return mInstance;
    }
	
	private static final int IMG_WIDTH = 320;
	private static final int IMG_HEIGHT = 240;
	
	private double centerX = 0.0;
    private VisionThread visionThread;
    private Pipeline pipeline = new Pipeline();
    
    public final Object imgLock = new Object();
    
	public Vision(){
		System.out.println("debug1");
		AxisCamera camera = CameraServer.getInstance().addAxisCamera("Axis","10.34.18.43/");
		System.out.println("debug2");
		CameraServer.getInstance().startAutomaticCapture(camera);
		System.out.println("debug3");
		camera.setResolution(IMG_WIDTH, IMG_HEIGHT);
		System.out.println("debug4");
		camera.setFPS(30);
		System.out.println("debug5");


		
		visionThread = new VisionThread(camera, pipeline, new VisionRunner.Listener<Pipeline>() {
		@Override
		public void copyPipelineOutputs(Pipeline pipeline) {
			if (!pipeline.filterContoursOutput().isEmpty()) {
				Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
				synchronized (imgLock) {
					centerX = r.x + (r.width / 2);
				}
			}
		}
		});
			
			
			
			/*
			
			if (!pipeline.filterContoursOutput().isEmpty()) {
				Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
				synchronized (imgLock) {
					centerX = r.x + (r.width / 2);
				}
			}
		});
		*/
		
		visionThread.start();
		
	}
	
	public void output(){
		CameraServer.getInstance().putVideo("camera1", 320, 240);
		//SmartDashboard.putNumber("centerX", centerX);
	}
	
	
}
