package lessons.lesson4.adapter2;

import java.io.FileNotFoundException;

public class AdapterApp {
    public void main(String[] args) {
        // 1 наследование
        VectorGraphicsInterface g1 = new VectorAdapterFromRaster();
        g1.drawLine();
        // 2 композиция
        VectorGraphicsInterface g2 = new VectorAdapterFromRaster2(new RasterGraphics());
        g2.drawSquare();
    }

    interface VectorGraphicsInterface{
        void drawLine();
        void drawSquare();
    }

    class RasterGraphics{
        void drawRasterLine(){
            System.out.println("Рисуем линию");
        }
        void drawRasterSquare(){
            System.out.println("Рисуем квадрат");
        }
    }

      class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface{
        @Override
        public void drawLine() {
            drawRasterLine();
        }

        @Override
        public void drawSquare() {
            drawRasterSquare();
        }
    }

      class VectorAdapterFromRaster2 implements VectorGraphicsInterface{
        RasterGraphics raster = null;
        public VectorAdapterFromRaster2(RasterGraphics raster){
            this.raster=raster;
        }

        @Override
        public void drawLine() {
            raster.drawRasterLine();
        }

        @Override
        public void drawSquare() {
            raster.drawRasterSquare();
        }
    }
}
