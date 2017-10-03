package algorithm.famous;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * (C) Copyright 2017 Ryan Donghyun Jin (http://ryanjin.net/).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p>
 * Contributors:
 * Ryan Donghyun Jin (atinjin@gmail.com)
 */
public class Pr_Cake_RectangleLove {
    /**
     *
     * https://www.interviewcake.com/question/java/rectangular-love
     *
     */
    public static Rectangle myFunction(Rectangle rec1, Rectangle rec2) {
        Rectangle result = new Rectangle();

        return result;
    }
    public static void main(String[] args) {
        // run your function through some test cases here
        // remember: debugging is half the battle!
        Rectangle rec1 = new Rectangle(0, 0, 5 ,5);
        Rectangle rec2 = new Rectangle(4, 4, 5, 5);

        Rectangle result = myFunction(rec1, rec2);
        System.out.println(result.toString());
    }

    public static class Rectangle {

        // "zero" rectangle
        public static final Rectangle NO_RECTANGLE = new Rectangle();

        // coordinates of bottom left corner
        private int leftX;
        private int bottomY;

        // dimensions
        private int width;
        private int height;

        private int[][] xy = new int[4][2];

        public Rectangle() {}

        public Rectangle(int leftX, int bottomY, int width, int height) {
            this.leftX = leftX;
            this.bottomY = bottomY;
            this.width  = width;
            this.height = height;
            xy[0][0] = leftX; //(X of left-bottom)
            xy[0][1] = bottomY; //(Y of left-bottom)
            xy[1][0] = leftX + width; //(X of right-bottom)
            xy[1][1] = bottomY;//(X of right-bottom)
            xy[1][0] = leftX; //(X of left-top)
            xy[1][1] = bottomY + height;//(X of left-top)
            xy[1][0] = leftX + width; //(X of right-top)
            xy[1][1] = bottomY + height;//(X of  right-top)

        }

        public int getLeftX() {
            return leftX;
        }

        public int getBottomY() {
            return bottomY;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public boolean isInside(int x, int y) {
            return (x > leftX) && (x < leftX + width)
                    && ( y > bottomY) && (y < bottomY + height);
        }

        @Override
        public String toString() {
            return String.format("leftX = %d, bottomY = %d, width = %d, height = %d"
                    , leftX, bottomY, width, height);
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Rectangle) {
                Rectangle rec = (Rectangle)obj;
                return rec.getLeftX() == this.leftX
                        && rec.getBottomY() == this.bottomY
                        && rec.getHeight() == this.height
                        && rec.getWidth() == this.width;
            } else
                return false;
        }
    }

    @Test
    public void test() {
        Rectangle rec1 = new Rectangle(0, 0, 5 ,5);
        Rectangle rec2 = new Rectangle(4, 4, 5, 5);

        Rectangle result = myFunction(rec1, rec2);
        assertEquals(new Rectangle(4, 4, 1, 1), result, "Rect Love");
    }
}
