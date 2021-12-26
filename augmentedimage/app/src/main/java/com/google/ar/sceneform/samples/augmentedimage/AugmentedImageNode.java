/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.ar.sceneform.samples.augmentedimage;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.ar.core.Anchor;
import com.google.ar.core.AugmentedImage;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.FixedWidthViewSizer;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.samples.ModelAction.ModelList;

import java.util.concurrent.CompletableFuture;

/**
 * Node for rendering an augmented image. The image is framed by placing the virtual picture frame
 * at the corners of the augmented image trackable.
 */
@SuppressWarnings({"AndroidApiChecker"})
public class AugmentedImageNode extends AnchorNode {


  private static CompletableFuture<ModelRenderable> ulCorner;
  private static CompletableFuture<ModelRenderable> urCorner;
  private static CompletableFuture<ModelRenderable> lrCorner;
  private static CompletableFuture<ModelRenderable> llCorner;
  private static CompletableFuture<ViewRenderable> CGUImageRenderable;
  private static CompletableFuture<ViewRenderable> CGUListRebderable;
  private View ListLayout=null;
  private View InfoLayout = null;
  private String[] department_name=new String[]{"資工","電機","機械","電子","化材"};
  private Anchor anchor = null;
  public AugmentedImageNode(Context context) {
    // Upon construction, start loading the models for the corners of the frame.
    if (ulCorner == null) {
      ulCorner =
          ModelRenderable.builder()
              .setSource(context, Uri.parse("models/frame_upper_left.sfb"))
              .build();
      urCorner =
          ModelRenderable.builder()
              .setSource(context, Uri.parse("models/frame_upper_right.sfb"))
              .build();
      llCorner =
          ModelRenderable.builder()
              .setSource(context, Uri.parse("models/frame_lower_left.sfb"))
              .build();
      lrCorner =
          ModelRenderable.builder()
              .setSource(context, Uri.parse("models/frame_lower_right.sfb"))
              .build();
    }

    CGUImageRenderable=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.5f)).setView(context,R.layout.cguimage).build();
    CGUListRebderable=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.25f)).setView(context,R.layout.cgulist).build();
    CGUImageRenderable.thenAccept( (renderable) -> {
          InfoLayout=renderable.getView();
    });
    CGUListRebderable.thenAccept(
            (renderable) -> {
                ListLayout=renderable.getView();
                ModelList modelList = new ModelList(context,ListLayout,InfoLayout);
                modelList.setListView((department_name));
            });
  }






  @SuppressWarnings({"AndroidApiChecker", "FutureReturnValueIgnored"})
  public void setImage(AugmentedImage image) {


    // If any of the models are not loaded, then recurse when all are loaded.
    if (!ulCorner.isDone() || !urCorner.isDone() || !llCorner.isDone() || !lrCorner.isDone()) {
      CompletableFuture.allOf(ulCorner, urCorner, llCorner, lrCorner)
          .thenAccept((Void aVoid) -> setImage(image))
          .exceptionally(
              throwable -> {
                return null;
              });
    }
    this.anchor = image.createAnchor(image.getCenterPose());
    // Set the anchor based on the center of the image.
    setAnchor(this.anchor);

    setModelRenderable(CGUListRebderable,1.5f * image.getExtentX(), 0.0f, 1f * image.getExtentZ());
    setModelRenderable(CGUImageRenderable,-1f * image.getExtentX(), 0.0f, 1f * image.getExtentZ());


  }

  private void setModelRenderable(CompletableFuture<ViewRenderable> renderable,float x,float y,float z){
      Node cornerNode;
      Vector3 localPosition = new Vector3();
      localPosition.set(x,y,z);
      cornerNode = new Node();
      cornerNode.setParent(this);
      cornerNode.setLocalPosition(localPosition);
      cornerNode.setLookDirection(Vector3.forward());

      cornerNode.setRenderable(renderable.getNow(null));
  }

  public  void removeAnchor(){
     this.anchor.detach();

  }

}
