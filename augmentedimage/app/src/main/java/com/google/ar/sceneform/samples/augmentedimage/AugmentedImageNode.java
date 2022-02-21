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

import com.google.ar.core.Anchor;
import com.google.ar.core.AugmentedImage;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.FixedWidthViewSizer;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.samples.ModelAction.DepartmentButton;
import com.google.ar.sceneform.samples.ModelAction.ModelALL;


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

  private static CompletableFuture<ViewRenderable> MedicalALLRenderable;

  private static CompletableFuture<ViewRenderable> DepartmentButtonRenderable;
  private   View medicalview;
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

//    CGUImageRenderable=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.5f)).setView(context,R.layout.cguimage).build();
//    CGUListRebderable=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.25f)).setView(context,R.layout.cgulist).build();
//    CGUImageRenderable.thenAccept( (renderable) -> {
//          InfoLayout=renderable.getView();
//    });
//    CGUListRebderable.thenAccept(
//            (renderable) -> {
//                ListLayout=renderable.getView();
//                ModelList modelList = new ModelList(context,ListLayout,InfoLayout);
//                modelList.setListView((department_name));
//            });


      MedicalALLRenderable=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.5f)).setView(context,R.layout.medical_all).build();

      DepartmentButtonRenderable=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.3f)).setView(context,R.layout.department_button).build();
      DepartmentButtonRenderable.thenAccept((renderable) -> {
          View view = renderable.getView();
          MedicalALLRenderable.thenAccept((Medicalrenderable) -> {
               medicalview = Medicalrenderable.getView();
              ModelALL medicalALL = new ModelALL("medical",context,medicalview);

          });


          DepartmentButton intro = new DepartmentButton(context,medicalview,view);
      });

//      Content.thenAccept(
//              (ContentRenderable) -> {
//                  View Contentview = ContentRenderable.getView();
//                  ModelIntro intro = new ModelIntro("Content",context,Contentview);
//
//              });


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
    //setModelRenderable(ListButtonRebderable,0f,0.1f, -1f * 0.13f);
    setModelRenderable(MedicalALLRenderable,0f,0.05f, -1f * 0.13f);

    //setModelRenderable(IndustryALLRenderable,1f* 0.13f,0.05f, -1f * 0.13f);
   // setModelRenderable(ManageALLRenderable,-1f* 0.13f,0.05f, -1f * 0.13f);

    setButtonRenderable(DepartmentButtonRenderable,0.3f * 0.13f,0,1f * 0.13f);
    //setModelRenderable(CGUManageRebderable,-3f * image.getExtentX(), 0f, 0.5f * image.getExtentZ());//x是左右，Y
    Log.d("Sizelog", String.valueOf(image.getExtentZ()));


  }

  private void setModelRenderable(CompletableFuture<ViewRenderable> renderable,float x,float y,float z){
      Node cornerNode;
      Vector3 localPosition = new Vector3();
      localPosition.set(x,y,z);
      cornerNode = new Node();
      cornerNode.setParent(this);
      cornerNode.setLocalPosition(localPosition);
      //cornerNode.setLookDirection(Vector3.forward());

      cornerNode.setRenderable(renderable.getNow(null));
  }

    private void setButtonRenderable(CompletableFuture<ViewRenderable> renderable,float x,float y,float z){
        Node cornerNode;
        Vector3 localPosition = new Vector3();
        localPosition.set(x,y,z);
        cornerNode = new Node();
        cornerNode.setParent(this);
        cornerNode.setLocalPosition(localPosition);
        cornerNode.setLookDirection(Vector3.down(),Vector3.forward());

        cornerNode.setRenderable(renderable.getNow(null));
    }

  public  void removeAnchor(){
     this.anchor.detach();

  }

}
